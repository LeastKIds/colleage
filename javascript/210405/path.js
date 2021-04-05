const path = require('path');

const string=__filename;
console.log(string);

console.log('path.sep : ',path.sep);
console.log('path.delimiter : ',path.delimiter);
console.log('-------------------------------');
console.log('path.dirname() : ',path.dirname(string));
console.log('path.extname() : ', path.extname(string));
console.log('path.basename() : ',path.basename(string));
console.log('path.basename - extname : ',path.basename(string, path.extname(string)));
console.log('-----------------------------------');
console.log('path.parse()',path.parse(string));
console.log('path.format() : ', path.format({
    dir : 'C\\users\\zeroch',
    name : 'path',
    ext : 'js'
}));
// .format(object) : path객체를 string으로 만들기
console.log('path.normalize() : ',path.normalize('c://users\\\zerocho\\\path.js')); // 평준화
console.log('-----------------------------------');
console.log('path.isAbsolute(C:\\) : ',path.isAbsolute('C:\\)'));
console.log('path.isAbsolute(./home) : ',path.isAbsolute('./home'));
console.log('-------------------------------------');
console.log('path.relative() : ',path.relative('C:\\users\\zeroch\\path.js','C:\\'));
console.log('path.join() : ',path.join(__dirname,'..','..','/users','.','/zeroch'));
console.log('path.resolve() : ',path.resolve(__dirname,'..','users','.','/zeroch'));