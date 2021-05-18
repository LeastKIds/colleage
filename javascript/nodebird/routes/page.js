// 자바로 따지면 import --------------------------------
const express = require('express');
// -----------------------------------------------------

const router = express.Router(); // 라우터를 깔끔하게 관리하기 위해서

// use : 모든 요청에서
router.use((req,res,next) => {  // 라우터에서 사용되는 미들웨어 정의
    res.locals.user=null;       // res.locals --> nunjucks에서 사용
    // 현재 로그인한 사람의 정보, 최초는 없기 때문에 null
    res.locals.followerCount=0;
    res.locals.followingCount=0;
    res.locals.followerIdList = [];
    next();
});

// get : /profile의 get요청시 실행
router.get('/profile', (req,res) => {
    // profile뷰 쪽으로 {title ...} 값을 전달
    res.render('profile', {title : '내 정보 - NodeBird'});
});

// /join의 get 요청시 실행
router.get('/join', (req,res) => {
    // join뷰 쪽으로 {title ...} 값을 전달
    res.render('join', {title : '회원가입 - NodeBird'});
});

// /의 get요청 시 실행 (최초 실행 시 여기로)
router.get('/', (req,res,next) => {
    // twits 이라는 빈 배열을 생성
    const twits=[];
    // main뷰 쪽으로 {title...}값을 전달
    res.render('main' , { // nunjucks의 설정에 의해서 app.js에 있는 views 설정대로 views폴더의 main.html 화면을 만든다.
        title : 'NodeBird',
        twits,
    });
});

module.exports = router; // 다른 곳에서 import 해줄 수 있게 해주는 것