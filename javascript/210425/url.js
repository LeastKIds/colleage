const url=require('url');

const { URL } = url;
const myURL = new URL('http://www.gilbut.co.kr/book/bookList.aspx?sercate1=0010010000#anchor');
console.log('new URL() : ',myURL);
console.log('url.format() : ',url.format(myURL));
console.log('------------------------------------');

const parseUrl=url.parse('http://www.gilbut.co.kr/book/bookList.aspx?sercate1=0010010000#anchor');
console.log('url.parse() : ', parseUrl);
console.log('url.format() : ',url.format(parseUrl));