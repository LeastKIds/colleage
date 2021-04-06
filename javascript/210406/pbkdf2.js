const crypto = require('crypto');

// base64 는 파일을 전송할 때 문자열로 바꾸어서(인코딩)보낼 때 사용한다.

crypto.randomBytes(64, (err, buf) =>        // 64 : 64길이의 랜덤 문자 생성 err,buf는 64개의 문자(byte)가 생성되면 콜백
{                                           // 64의 결과값은 buf에 저장
    console.log(buf);
    const salt=buf.toString('base64');
    console.log('salt : ',salt);
    crypto.pbkdf2('비밀번호',salt,100000,64,'sha512',(err,key) =>
    // 100000 : 반복 횟수
    // 64 : 길이
    // sha512 : 암호 알고리즘
    // key : 최종 결과를 저장
    {
        console.log('password : ',key.toString('base64'));
    });
});