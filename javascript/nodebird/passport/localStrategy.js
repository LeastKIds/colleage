const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
const bcrypt = require('bcrypt');

const User = require('../models/user');

module.exports = () => {    // 데이터베이스에 접속해서 email과 password를 가져옴
    passport.use(new LocalStrategy({
        usernameField : 'email',
        passwordField : 'password',
    }, async(email,password,done) => {  // 이 부분이 로그인 과정
        try {
            const exUser = await User.findOne({where : {email}});   // 데이터베이스에서 해당 email이 존재하는지
            if(exUser) {    // email이 존재한다면
                const result = await bcrypt.compare(password,exUser.passport);  // 데이터베이스에서 해당 비밀번호가 같은지
                if(result) {
                    done(null, exUser); // 같으면 정보를 넘김. null, exUser : passport.authenticate('local',(authError, user, info)) 에서 authError,user 부분
                } else {
                    done(null, false, { message : '비밀번호가 일치하지 않습니다.'});    // 비밀 번호가 틀릴 경우. message 는 info 부분
                }
            } else {
                done(null, false, {message : '가입되지 않은 회원입니다.'}); // email이 틀릴 경우
            }
        } catch (error) {
            console.error(error);
            done(error);        // 서버 에러. authError 부분
        }
    }));
};