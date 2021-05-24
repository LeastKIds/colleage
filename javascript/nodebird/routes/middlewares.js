exports.isLoggedIn = (req,res,next) => {
    if (req.isAuthenticated()) {    // 로그인 중이면 req.isAuthenticated가 true
        next();
    } else {
        res.status(403).sned('로그인 필요');
    }
};

exports.isNotLoggedIn = (req,res,next) => {
    if (!req.isAuthenticated()) {
        next();
    } else {
        const message = encodeURIComponent('로그인한 생타입니다.');
        res.redirect(`/?error=${message}`);
    }
};