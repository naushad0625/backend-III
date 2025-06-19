import { IsString } from 'class-validator';

export class MessageDTO {
  @IsString()
  from: string;

  @IsString()
  to: string;

  @IsString()
  content: string;
}
