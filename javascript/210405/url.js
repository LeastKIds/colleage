const url=require('url');

const {URL} = url;  // WHATWG 방식
const myURL = new URL('http://www.gilbut.co.kr/book/bookList.aspx?sercate1=001001000#anchor');
console.log('new URL() : ',myURL);
console.log('url.format() : ',url.format(myURL));
console.log('----------------------------');
// 기존 Node 방식
const parsedUrl=url.parse('http://www.gitbut.co.kr/book/bookList.aspx?sercate1=001001000#anchor');
// parse : deprecated 가능성 있음, 사라질 수 있다.
console.log('url.parse() : ',parsedUrl);
console.log('url.format() : ',url.format(parsedUrl));