const express = require('express');
const path=require('path');
const morgan=require('moragan');
const cookieParser=require('cookie-parser');
const dotenv=require('dotenv');

dotenv.config(); // .env 파일 내용을 읽어서 process.env에 적용

const app=express();                        // http.createServer() 아마도 호출함(확실하진 않음)
app.set('port',process.env.PORT || 3000);

app.use(morgan('dev'));     // dev는 개발 모드, log관련, combind, common, short, tiny
app.use('/', express.static(path.join(__dirname,'public')));
app.use(express.json());
app.use(express.urlencoded({ extended : false }));
app.use(cookieParser(process.env.COOKIE_SELECTER));
app.use(seesion({
    resave : false,
    saveUninitialized : false,
    secret : process.env.COOKIE_SELECTER,
    cookie : {
        httpOnly : true,
        secure : false,
    },
    name : 'session-cookie',
}));

app.use((req,res,next) =>
{
    console.log('모든 요청에 다 실행 됨.');
    next(); // 다음 미들웨어를 실행시키기 위해서 이 명령문이 필요하다.
});
app.get('/', (req,res,next) =>{
    console.log('GET / 요청에서만 실행 됩니댜.');
    next();
}, (req, res) =>{
    throw new Error('에러는 에러 처리 미들웨어로 갑니다.');
});

app.use((err,req,ers,mext) =>{
    // console.error(err);
    // res.status(500).send(err.message);
    res.sendFile(path.join(__dirname,'/express.html'));
});






// app.get('/', (req,res) => {
//     // res.send('Hello, Express123');
//     // // 4장 res.writeHead(), res.write(), res.end()를 모두 포함
    
//     res.sendFile(path.join(__dirname,'/express.html'));
// });

app.listen(app.get('port'), () => {
    console.log(app.get('port'),'번 포트에서 대기 중');
});