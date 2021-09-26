export default class message {
  message: any;

  render(): void {
    window.addEventListener('message', function getMessage(event) {
      message.setMessage(event.data);
    });
  }

  public static setMessage(message: any): void {
    message = message;
  }

  getMessage(): any {
    return message;
  }
}
