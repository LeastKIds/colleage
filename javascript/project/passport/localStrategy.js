const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy; // 인증 방법
const bcrypt = require('bcrypt'); // 암호화

const User = require('../models/user'); 

module.exports = () => {
  passport.use(new LocalStrategy({  // 인증 방법
    usernameField: 'email', // usernameField 를 email로 재정의
    passwordField: 'password',  // passwordField를 password로 재정의
  }, async (email, password, done) => {
    try {
      const exUser = await User.findOne({ where: { email } });  // user에서 해당 이메일이 있는 지확인
      if (exUser) { // 만약 있다면
        const result = await bcrypt.compare(password, exUser.password); // 패스워드를 암호화 시킨 뒤 해당 이메일의 비밀번호와 비교
        if (result) { // 일치 한다면
          done(null, exUser); // 다음으로 넘김
        } else {  // 일치하지 않는다면
          done(null, false, { message: '비밀번호가 일치하지 않습니다.' });  // 해당 오류 문구를 보냄
        }
      } else {  // 만약 이메일이 없다면
        done(null, false, { message: '가입되지 않은 회원입니다.' });  // 해당 오류 문구를 보냄
      }
    } catch (error) {
      console.error(error);
      done(error);
    }
  }));
};
