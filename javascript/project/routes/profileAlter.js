const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

const { Post, User,  Comment } = require('../models');
const { isLoggedIn } = require('./middlewares');
const { addListener } = require('process');
const { userInfo } = require('os');

const router = express.Router();

router.get('/', isLoggedIn, async(req,res,next) => {    // /으로 get 요청이 들어올 시 로그인 되어있으면 다음 내용이 실행됨
    return res.render('profileAlter',{  // profileAlter.html로 다음 내용을 보내줌
        title : '자기소개 수정',
       
    });
});

router.post('/alter', isLoggedIn, async(req,res,next) => {  // /alter으로 post 요청으로 올 시 로그인 되어있으면 다음 내용이 실행됨
    await User.update({ // 업데이트
        introduction : req.body.content,    // 해당 내용으로 업데이트
    }, {
        where : {id : req.user.id },    // 업데이트 위치
    });

    const user = await User.findOne({   // user 테이블에서 결과 값 하나를 가져옴
        where : { id : req.user.id },
    });
    
    return res.render('profile', {  // profile.html로 다음 내용을 전달함
        user : user,
    })
})
module.exports = router;