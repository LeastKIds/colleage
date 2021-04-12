const fs=require('fs');

const writeStream = fs.createWriteStream(__dirname + '/writeme2.txt');

writeStream.on('finish',() =>
{
    console.log('파일 쓰기 완료');
});

writeStream.write('이글을 씁니다. \n');
writeStream.write('한 번 더 씁니다.');
writeStream.end();