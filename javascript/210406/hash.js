const crypto = require('crypto');

console.log('base64',crypto.createHash('sha512').update('비밀번호').digest('base64'));
//  createHash : 사용할 알고리즘을 선택하여 crypto 객체 생성
// , update : '비밀번호'를 암호화 처리
// , digest : base64로 엔코딩 처리
console.log('hex : ',crypto.createHash('sha512').update('비밀번호').digest('hex'));
console.log('base64',crypto.createHash('sha512').update('다른 비밀번호').digest('base64'));