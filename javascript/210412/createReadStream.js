const fs=require('fs');

const readStream = fs.createReadStream(__dirname+'/readme3.txt',{highWaterMark : 16});  // highWaterMark : chunk 길이
const data = [];

readStream.on(  // on : 이벤트와 이벤트리스너를 연결하는 메소드
    'data',    // data : 이벤트 명, 처리할 데이터가 있으면 발생하는 이벤트
(chunk) =>               // 이벤트 처리 함수(콜백함수) / 이벤트 핸들러, 이벤트 리스너
{
    data.push(chunk);
    console.log('data : ',chunk,chunk.length);
});

readStream.on('end' ,() =>
{
    console.log('end : ',Buffer.concat(data).toString());
});

readStream.on('error', (err) =>
{
    console.log('error : '.err);
});