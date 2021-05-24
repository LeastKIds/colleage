const passport = require('passport');
const local = require('./localStrategy');
const kakao = require('./kakaoStrategy');
const User = require('../models/User');

module.exports = () => {
    // 로그인 시 실행되며, req.seesion 객체에 어떤 데이터를 저장할지 정하는 메서드
    passport.serializeUser((user, done) => {    // 매개 변수로 user를 받고, done 함수에 두 번째 인수로 user.id를 넘김
        done(null, user.id);    // 에러 발생시 null, user.id는 저장하고 싶은 데이터 (세션에 모든 데이터를 저장하면 세션의 용량이 커지고 데이터의 일관성 문제가 발생. 그래서 id만 저장)
    });

    // 매 요청시 실행 (passport.session 미들웨어가 이 메서드를 호출). 위의 doen의 두 번재 인수로 넣었던 데이터가 아래의 매개 변수로 사용
    passport.deserializeUser((id, done) => {
        console.log(id)    
        User.findOne( { where : { id } })   // 데이터베이스 조회. 
        .then(user => done(null, user)) // 조회한 정보를 user에 저장하고 이걸 req.user에 저장
        .catch(err => done(err));
    });

    local();
    kakao();
}