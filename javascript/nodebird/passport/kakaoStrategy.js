const passport = require('passport');
const KakaoStrategy = require('passport-kakao').Strategy;

const User = require('../models/user');

module.exports = () => {
    passport.use(new KakaoStrategy({
        clientID : process.env.KAKAO_ID,    // 카카오로 부터 발급해 주는 id. 노출되면 안되서 env로 감춤
        callbackURL : '/auth/kakao/callback',   // 카카로올 부터 인증 결과를 받을 라우터 주소
    }, async(accessToken, refreshToken, profile, done) => {
        console.log('kakao profile',profile);
        try {
            const exUser = await User.findOne({ // 카카오를 통해 회원가입한 사용자가 있는지 조회
                where : {snsId : profile.id, provider : 'kakao'},
            });
            if(exUser) {
                done(null, exUser); // 카카오로 회원가입했다면 통과
            } else {    // 없다면 회원가입 진행
                const newUser = await User.create({
                    email : profile._json && profile._json.kakao_accout_email,
                    nick : profile.displayName,
                    snsId : profile.id,
                    provider : 'kakao',
                });
                done(null, newUser);
            }
        } catch (error) {
            console.error(error);
            done(error);
        }
    }));
};