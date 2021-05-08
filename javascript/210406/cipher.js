const crypto = require('crypto');

const algorithm = 'aes-256-cbc';
const key = 'abcdefghijklmnopqrstuvwxyz123456';     // 32바이츠로 설정해야 함   (2.난 이 비밀번호를 치면) 3.공인인증서 인증이 됨
const iv = '1234567890123456';                      // 16바이츠로 설정해야 함 (1.공인인증서는 이걸 가지고 있고)
const cipher = crypto.createCipheriv(algorithm,key,iv);
let result=cipher.update('암호화할 문장','utf8','base64');
result += cipher.final('base64');
console.log('암호화 : ',result);

const decipher=crypto.createDecipheriv(algorithm,key,iv);
let result2=decipher.update(result,'base64','utf8');
result2+=decipher.final('utf8');
console.log('복호화 : ',result2);