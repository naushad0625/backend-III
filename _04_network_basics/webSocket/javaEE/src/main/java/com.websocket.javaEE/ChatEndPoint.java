package com.websocket.javaEE;


import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/chat/{userName}", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class ChatEndPoint {

    private Session session;
    private static Set<ChatEndPoint> chatEndPoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();


    @OnOpen
    public void onOpen(Session session, @PathParam("userName") String userName) throws IOException {
        this.session = session;
        chatEndPoints.add(this);
        users.put(session.getId(), userName);

        Message message = new Message();
        message.setFrom(userName);
        message.setContent("connected!");
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Message message, Session session) throws IOException {
        message.setFrom(users.get(session.getId()));
        broadcast(message);
    }

    @OnClose
    public void onClose(Session session) {
        chatEndPoints.remove(this);
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("Disconnected!");
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    private static void broadcast(Message message) {
        chatEndPoints.forEach(endPoint -> {
            synchronized (endPoint) {
                try{
                    endPoint.session.getBasicRemote().sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
