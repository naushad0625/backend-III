import { Controller, Get, Res } from '@nestjs/common';
import { Response } from 'express';
import { join } from 'path';

@Controller('chat')
export class ChatController {
  @Get('/')
  async serve(@Res() response: Response) {
    return response.sendFile(
      join(__dirname, '..', '..', 'public', 'index.html'),
    );
  }
}
