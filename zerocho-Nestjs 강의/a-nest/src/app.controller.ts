import { Controller, Get, Post } from '@nestjs/common';
import { AppService } from './app.service';

@Controller('abc')
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get('user') // GET /abc/user
  getHello(): string {
    return this.appService.getUser();
  }

  @Post('user') // POST /abc/user
  postHello(): string {
    return this.appService.postUser();
  }
}
