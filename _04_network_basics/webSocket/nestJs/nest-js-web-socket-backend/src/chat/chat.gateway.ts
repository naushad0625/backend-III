import {
  OnGatewayConnection,
  OnGatewayDisconnect,
  SubscribeMessage,
  WebSocketGateway,
  WebSocketServer,
} from '@nestjs/websockets';
import { Server, Socket } from 'socket.io';

type Payload = {
  channel: string;
  message: string;
};

@WebSocketGateway(3001, {
  cors: {
    origin: '*',
  },
})
export class ChatGateway implements OnGatewayConnection, OnGatewayDisconnect {
  @WebSocketServer()
  server: Server;

  private userToChannel = new Map<string, Set<string>>();
  private channelToUser = new Map<string, Set<string>>();
  private userToSocket = new Map<string, Socket>();
  private socketToUser = new Map<string, string>();

  private static clients = new Set<Socket>();
  private static users: Record<string, string> = {};

  handleConnection(client: Socket) {
    const userName = client.handshake.query.userName as string;
    if (!userName) {
      client.disconnect();
      console.log('Disconnected! no userName provided.');
      return;
    }

    client.data.userName = userName;

    this.userToSocket.set(userName, client);
    this.socketToUser.set(client.id, userName);
    console.log(`User '${userName}' connected to server.`);
    ChatGateway.clients.add(client);
    ChatGateway.users[client.id] = userName;
  }

  handleDisconnect(client: Socket) {
    const userName = this.socketToUser.get(client.id);
    if (!userName) return;

    const channels = this.userToChannel.get(userName) || new Set();

    for (const channel of channels) {
      this.channelToUser.get(channel)?.delete(userName);
      if (this.channelToUser.get(channel)?.size === 0)
        this.channelToUser.delete(channel);
    }

    this.userToChannel.delete(userName);
    this.userToSocket.delete(userName);
    this.socketToUser.delete(client.id);

    console.log(`${userName} disconnected`);
  }

  // Join to  a channel
  @SubscribeMessage('JoinIntoChannel')
  handleChannelJoin(client: Socket, channel: string) {
    const userName = client.data.userName;
    if (!userName) return;

    // update userToChannel
    if (!this.userToChannel.has(userName))
      this.userToChannel.set(userName, new Set());
    this.userToChannel.get(userName).add(channel);

    // update channelToUser
    if (!this.channelToUser.has(channel))
      this.channelToUser.set(channel, new Set());
    this.channelToUser.get(channel).add(userName);

    client.join(channel);
    this.server.to(channel).emit('joined', { user: userName, channel });
  }

  // Leave from a channel
  @SubscribeMessage('LeaveChannel')
  handleChannelLeave(client: Socket, channel: string) {
    const userName = client.data.userName;
    if (!userName) return;

    // update userToChannel
    this.userToChannel.get(userName)?.delete(channel);
    if (this.userToChannel.get(userName)?.size === 0)
      this.userToChannel.delete(userName);

    // update channelToUser
    this.channelToUser.get(channel)?.delete(userName);
    if (this.channelToUser.get(channel)?.size === 0)
      this.channelToUser.delete(channel);

    this.server.to(channel).emit('leaved', { user: userName, channel });
    client.leave(channel);
  }

  // Private message/Group message
  @SubscribeMessage('ChannelMessage')
  handlePrivateMessage(client: Socket, payload: Payload) {
    const userName = client.data.userName;
    const { channel, message } = payload;

    if (
      !this.userToChannel.has(userName) ||
      !this.userToChannel.get(userName).has(channel)
    )
      return;

    console.log(userName, channel, message);

    this.server.to(channel).emit('message', {
      from: userName,
      channel: channel,
      message: message,
    });
  }

  // Public message
  @SubscribeMessage('PublicMessage')
  handlePublicMessage(client: Socket, payload: Payload) {
    const userName = client.data.userName;
    const { channel, message } = payload;
    console.log(userName, channel, message);
    this.server.emit('message', {
      from: userName,
      message: message,
      channel: channel,
    });
  }
}
