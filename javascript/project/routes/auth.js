// 로그인 라우터


const express = require('express');
const passport = require('passport'); // 로그인 확인
const bcrypt = require('bcrypt'); // 암호화
const { isLoggedIn, isNotLoggedIn } = require('./middlewares'); // 로그인 중인지 확인
const User = require('../models/user'); // 데이터베이스에서 user 테이블 가져옴

const router = express.Router();

router.post('/join', isNotLoggedIn, async (req, res, next) => { // join에 post로 로그인이 되어 있지 않다면 다음 함수를 실행시켜라
  const { email, nick, password } = req.body; // req.body로 넘오는 값들을 변수에 저장
  try {
    const exUser = await User.findOne({ where: { email } });  // 해당 이메일이 있는지
    if (exUser) { // 있다면
      return res.redirect('/join?error=exist'); // 실패했다고 보냄
    }
    const hash = await bcrypt.hash(password, 12); // 비밀 번호를 받아서 암호화 하기
    await User.create({ //user 테이블에 새로운 행 만들기
      email,  // email : email
      nick, // nick : nick
      password: hash,
    });
    return res.redirect('/'); // 맨 처음 화면으로
  } catch (error) {
    console.error(error);
    return next(error);
  }
});

router.post('/login', isNotLoggedIn, (req, res, next) => {  // loing에 post로 로그인 되어있지 않다면 다음을 실행
  passport.authenticate('local', (authError, user, info) => { // localStrategy를 불러옴
    if (authError) {  // 오류가 발생할 시
      console.error(authError);
      return next(authError);
    }
    if (!user) {  // 만약 유저가 없을 경우
      return res.redirect(`/?loginError=${info.message}`);  // 오류 메세지 발송
    }
    return req.login(user, (loginError) => {  // 로그인 시
      if (loginError) { // 로그인 에러시
        console.error(loginError);
        return next(loginError);
      }
      return res.redirect('/');
    });
  })(req, res, next); // 미들웨어 내의 미들웨어에는 (req, res, next)를 붙입니다.
});

router.get('/logout', isLoggedIn, (req, res) => { // logout에 get으로 들어오면 로그인 시 다음을 실행
  req.logout(); // 로그아웃
  req.session.destroy();  // 세션 파괴
  res.redirect('/');  // 맨 처음 페이지로
});

router.get('/kakao', passport.authenticate('kakao')); // 카카오

router.get('/kakao/callback', passport.authenticate('kakao', {
  failureRedirect: '/',
}), (req, res) => {
  res.redirect('/');
});

module.exports = router;
