const http = require('http');
const fs = require('fs').promises;
const url = require('url');
const qs = require('querystring');

const parseCookies = (cookie = '') =>   // cookie의 디폴트 값 설정, parseCookies() 호출 가능
  cookie                                // 화살표 함수는 다 생략하고 바로 리턴함
    .split(';') // 결과가 배열 ; 단위로 끊음 [name=???, Expires=?????, HttpOnly, Path=/]
    .map(v => v.split('='))         // = 단위로 끊음    [name, ???], [Expires, ?????], ...
    .reduce((acc, [k, v]) => {      // reduce : 배열을 객체로 바꿈
      acc[k.trim()] = decodeURIComponent(v);
      return acc;
    }, {});                 // {name:???}, {Expires:?????}, ...

http.createServer(async (req, res) => {
  const cookies = parseCookies(req.headers.cookie); // { mycookie: 'test' }
  // 주소가 /login으로 시작하는 경우
  if (req.url.startsWith('/login')) {   // 메서드 지정 안하면 GET 요청이라 인지
    // GET / login 요청 처리 부분
    const { query } = url.parse(req.url);
    const { name } = qs.parse(query);
    const expires = new Date();
    // 쿠키 유효 시간을 현재시간 + 5분으로 설정
    expires.setMinutes(expires.getMinutes() + 5);
    res.writeHead(302, {
      Location: '/',
      'Set-Cookie': `name=${encodeURIComponent(name)}; Expires=${expires.toGMTString()}; HttpOnly; Path=/`,
    });
    res.end();
  // name이라는 쿠키가 있는 경우
  } else if (cookies.name) {
    res.writeHead(200, { 'Content-Type': 'text/plain; charset=utf-8' });
    res.end(`${cookies.name}님 안녕하세요`);
  } else {
    try {
      const data = await fs.readFile('./cookie2.html');
      res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
      res.end(data);
    } catch (err) {
      res.writeHead(500, { 'Content-Type': 'text/plain; charset=utf-8' });
      res.end(err.message);
    }
  }
})
  .listen(8084, () => {
    console.log('8084번 포트에서 서버 대기 중입니다!');
  });