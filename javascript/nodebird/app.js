// 자바로 따지면 import -----------------------
const express = require('express');
const cookieParser = require('cookie-parser');
const morgan = require('morgan');
const path = require('path');
const session = require('express-session');
const nunjucks = require('nunjucks');
const dotenv = require('dotenv');
const passport = require('passport');
// ---------------------------------------------

dotenv.config(); // dotenv를 사용하기 위한 설정. 비밀번호같은 걸 다른 파일에 저장해서 불러와서 씀
const pageRouter = require('./routes/page');
const { sequelize } = require('./models');
const passportConfig = require('./passport');

const app = express();
passportConfig();   // 패스포트 설정
app.set('port',process.env.PORT || 8001);   // 포트 번호 세팅. 초기 설정이 없으면 8001로 설정
app.set('view engine', 'html'); // 넌적스 사용. html을 좀더 유연하게 사용 가능
nunjucks.configure('views', {
    express : app,
    watch : true,
});

sequelize.sync({ force : false })       // 시작 할 때 마다 데이터 베이스를 새로 만들건가
.then( () => {
    console.log('데이터베이스 연결 성공');
})
.catch( (err) => {
    console.error(err);
});

app.use(morgan('dev')); // 현재 돌아가는 상황을 나타 내 줌.
app.use(express.static(path.join(__dirname, 'public')));    // public의 폴더 경로를 숨겨줌.
app.use(express.json());
app.use(express.urlencoded({ extended : false}));   // false : 노드의 queryString 모듈을 사용하여 해석, true : qus 모듈을 사용하여 쿼리스트링을 해석
app.use(cookieParser(process.env.COOKIE_SECRET));
app.use(session({
    resave : false, // 요청이 올 때 세션에 수정상항이 생기지 않더라고 세션을 다시 저장할 지 설정.
    saveUninitialized : false,  // 세션에 저장할 내역이 없더라도 처음부터 세션을 생성할지 설정
    secret : process.env.COOKIE_SECRET, // 안전하게 쿠키를 보낼려면 secret 값인 서명이 필요함
    cookie : {
        httpOnly : true,    // 클라이언트에서 쿠키 확인 X
        secure : false,     // https를 적용하는 부분
    },
}));

app.use('/', pageRouter);

// 404 응답 미들웨어. 만약 404에 해당하는 에러가 나타나면 해당 값을 에러 미들웨어로 넘김.
app.use((req,res,next) => {
    const error = new Error(`${req.method} ${req.url} 라우터가 없습니다.`); // 에러 발생
    error.status = 404;
    next(error);    // 에러 라우터로 이동
});

// 파라미터가 4개이므로 에러 미들웨어
app.use((err,req,res,next) => {
    res.locals.message = err.message;   // 에러가 나면 locals.message는 ... 라우터가 없습니다로 바뀜.
    res.locals.error = process.eventNames.NODE_ENV !== 'production' ? err : {}; // 보안 상 배포판이 아닌 경우에만 에러를 표시
    res.status(err.status || 500);
    res.render('error');        // error.html 쪽으로 넘겨줌
});


// 위에는 다 설정, 여기서 서버 실행
app.listen(app.get('port') , () => {
    console.log(app.get('port'), '번 포트에서 대기중');
});