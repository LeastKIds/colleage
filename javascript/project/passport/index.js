const passport = require('passport');
const local = require('./localStrategy');
const kakao = require('./kakaoStrategy');
const User = require('../models/user');

module.exports = () => {  // 밖으로 내보내기
  passport.serializeUser((user, done) => {  // 로그인 시 실행
    done(null, user.id);
  });

  passport.deserializeUser((id, done) => {  // 매 순간 실행
    User.findOne({  // 팔로워를 확인 하는 부분이지만, 현재로써는 사용하지 않기 때문에 필요 없다.
      where: { id },
      include: [{
        model: User,
        attributes: ['id', 'nick'],
        as: 'Followers',
      }, {
        model: User,
        attributes: ['id', 'nick'],
        as: 'Followings',
      }],
    })
      .then(user => done(null, user))
      .catch(err => done(err));
  });

  local();  // 로컬 부분
  kakao();  // 카카오 부분
};
