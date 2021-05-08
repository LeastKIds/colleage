const http = require('http');

// http.createServer((req,res) =>  // http.Server 객체를 생성
// {                               // (req,res) = 콜백, req : request, res : response
//                                 // 언제 값이 돌아올지 모르므로 콜백형태.


//     // 여기에 어떻게 응답할지 적습니다.


// }); // Server 객체가 만들어짐.

http.createServer(
    (req,res) =>
    {
        res.writeHead(
            200, // 응답코드
            {'Content-Type' : 'text/html; charset=utf8'}    // 헤더들
        );
        res.write('<h1>안녕 노드!</h1>');
        res.end('<p>헬로 서버!</p>');
    }
).listen(
    8081,                   // 포트 번호 : 서버(기계)의 해당 서비스 구분(프로세스 구분)
    () =>{
        console.log('8081번 포트에서 서버 대기 중입니다!');
        console.log('http://localhost:8081/ 접속');
    }
);