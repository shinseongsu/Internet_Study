import message from './message';

let url: string;
let data: object;

export default class baroPayments {
  private Message: message = new message();

  constructor() {
    url = 'https://devbaropay.bluewalnut.co.kr/store/requestPayAuth.do';
    data = {
      amount: '10001',
      clientKey: '626c75657061795f3132333435363738',
      closeUrl: '/cmm/intro.do',
      currency: 'KRW',
      customerEmail: 'baro@bluewalnut.co.kr',
      customerMobilePhone: '01012345678',
      customerName: '김바로',
      encryptedCi: '',
      goodsName: '추석선물(냉동)',
      installmentAllow: 'N',
      installmentMonths: '02:03:04:05:06:07:08:09:10:11:12:24:36',
      interestFreeInstallmentMonths: '04:08:12:24:36',
      memberVerifiedKey:
        'edJfhX8MTEWl1jiPyn1taTaGTJSWWCik05ecbgVmoP8XovguVEEGcPg57glD9Whd',
      orderId: 'orderId_210927122923843',
      pgCode: 'BWPG',
      pointUse: 'Y',
      returnUrl: '/cmm/intro.do',
      supplyPlace: '9001',
      taxFreeAmount: '1000',
      vat: '900',
    };
  }

  iframe = new Promise((resolve, reject) => {
    let form = document.createElement('form');
    form.setAttribute('method', 'post');

    let values = Object.values(data);
    let keys = Object.keys(data);
    let i = 0;

    for (const key in data) {
      let element = document.createElement('input');
      element.setAttribute('type', 'hidden');
      element.setAttribute('name', key);
      element.setAttribute('value', values[i]);
      form.appendChild(element);
      i = i + 1;
    }

    document.body.appendChild(form);

    let iframe = document.createElement('iframe');
    iframe.setAttribute('name', 'bpIframe');
    iframe.style.border = '1px solid #000';
    iframe.style.position = 'fixed';
    iframe.style.zIndex = '999';
    iframe.style.left = '0px';
    iframe.style.top = '0px';
    iframe.style.width = '100%';
    iframe.style.height = '100%';

    document.body.appendChild(iframe);
    form.setAttribute('target', 'bpIframe');

    form.setAttribute('action', url);
    form.submit();
  });

  postMessageCheck() {
    this.Message.render();

    new Promise((resolve, reject) => {
      let timeId = setInterval(() => {
        if (this.Message.getMessage != null) {
          clearInterval(timeId);

          let msg = this.Message.getMessage;

          resolve(msg);
        }
      }, 100);
    });
  }

  requestPayment(): void {
    this.iframe
      .then(this.postMessageCheck)
      .then((message) => {
        alert(message);
      })
      .catch((message) => {
        alert(message);
      });
  }
}
