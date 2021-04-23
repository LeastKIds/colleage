const http=require('http');
const fs=require('fs').promises;

http.createServer(async (req,res) =>
{
    try{
        const data=await fs.readFile(__dirname+'/server2.html');    // data 타입 : Buffer 객체
        res.writeHead(200, {'Content-Type' : 'text/html; charset=utf-8'});  // 응답 코드 : 200(정상)
        res.end(data);
    }catch(err)
    {
        console.error(err);
        res.writeHead(500, {'Content-Type' : 'test/plain; charset=utf-8'}); // 응답 코드 : 500(에러)
        res.end(err.message);
    }
}).listen(8081, () =>
{
    console.log('8081번 포트에서 서버 대기 중입니다!');
});