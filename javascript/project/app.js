// 맨 처음 실행 되는 파일


// 모듈 불러오기
const express = require('express');
const cookieParser = require('cookie-parser');
const morgan = require('morgan');
const path = require('path');
const session = require('express-session');
const nunjucks = require('nunjucks');
const dotenv = require('dotenv');
const passport = require('passport');

// 보안이 필요한 부분을 불러오기
dotenv.config();

// 라우터 등록
const pageRouter = require('./routes/page');
const authRouter = require('./routes/auth');
const postRouter = require('./routes/post');
const userRouter = require('./routes/user');
const profileRouter = require('./routes/profile');
const postTitleRouter=require('./routes/postTitle');
const profileAlterRouter=require('./routes/profileAlter');
const introductionRouter = require('./routes/introduction');

// 시퀄라이즈
const { sequelize } = require('./models');
// 패스포트 (로그인 담당, 현재 아이디 확인)
const passportConfig = require('./passport');

const app = express(); // express 설정
passportConfig(); // 패스포트 설정
app.set('port', process.env.PORT || 8001);  // .env에 있는 PORT 값을 넣어줌. 없으면 8001
app.set('view engine', 'html'); // 넌적스 설정 페이지
nunjucks.configure('views', {
  express: app,
  watch: true,
});
// 데이터베이스 연결 부분 force 가 true면 매번 새 데이터베이스를 생성함. 
sequelize.sync({force : false })
  .then(() => {
    console.log('데이터베이스 연결 성공');
  })
  .catch((err) => {
    console.error(err);
  });

app.use(morgan('dev')); // 콘솔에 찍히는 상태 메세지 설정
app.use(express.static(path.join(__dirname, 'public')));  // 스태틱 경로를 설정해, 외부에서 보여지는 경로를 숨겨줌
app.use('/img', express.static(path.join(__dirname, 'uploads')));
app.use(express.json());  // 제이슨 설정
app.use(express.urlencoded({ extended: false })); // 언어 설정
app.use(cookieParser(process.env.COOKIE_SECRET)); // 쿠키 설정(로그인 확인). .env파일에 COOKIE_SECRET 부분 설정
app.use(session({ // 쿠키 세션 부분
  resave: false,  // 모든 request마다 seesion 변동사항이 없더라도 다시 저장할지.
  saveUninitialized: false, // request 가 들어오면 해당 request 에서 새로 생성된 session 에 아무런 작업이 이루어지지 않는 상황을 말함.
  secret: process.env.COOKIE_SECRET,  // 암호 변조를 위한 값
  cookie: {
    httpOnly: true, // 자바스크립트 document.cookie 에서 쿠키 실행을 막아주는 역할(프론트)
    secure: false,  // http에서 쿠키 사용가능
  },
}));
app.use(passport.initialize()); // 패스포트 설정
app.use(passport.session());  // 패스포트 세션 설정

// 해당 경로로 요청이 들어오면 router로 연결해줌
app.use('/', pageRouter);
app.use('/auth', authRouter);
app.use('/post', postRouter);
app.use('/user', userRouter);
app.use('/postTitle', postTitleRouter); 
app.use('/profile', profileRouter);
app.use('/profileAlter', profileAlterRouter);
app.use('/introduction',introductionRouter);

// 오류 발생 미들웨어
app.use((req, res, next) => {
  const error =  new Error(`${req.method} ${req.url} 라우터가 없습니다.`);
  error.status = 404;
  next(error); // 여기서 오류로 넘겨줌
});

// 오류 처리 미들웨어
app.use((err, req, res, next) => {
  res.locals.message = err.message;
  res.locals.error = process.env.NODE_ENV !== 'production' ? err : {};  // 개발자가 아닌 소비자의 입장에선 오류 표시 안함
  res.status(err.status || 500); 
  res.render('error');
});

// 서버 접속
app.listen(app.get('port'), () => {
  console.log(app.get('port'), '번 포트에서 대기중');
});
