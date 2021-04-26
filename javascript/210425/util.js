const util=require('util');
const crypto=require('crypto');

const dontUseMe=util.deprecate((x,y) => {
    console.log(x+y);
}, '사용하지마');
dontUseMe(1,2);

const randomBytePromise=util.promisify(crypto.randomBytes);
randomBytePromise(64)
.then((buf) => {
    console.log(buf.toStrinf('base64'));
})
.catch((error) => {
    console.error(error);
});