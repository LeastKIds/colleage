const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

const { Post, User,  Comment } = require('../models');
const { isLoggedIn } = require('./middlewares');
const { addListener } = require('process');

const router = express.Router();


router.get('/', isLoggedIn, async (req, res) => {   // /로 get요청이 들어올 시 로그인이 되어 있으면 다음 이 실행됨
  
    const user = await User.findOne({   // user 테이블에서 결과값 하나를 가져옴
        where : {id : req.user.id},
    });

    return res.render('profile', {  // profile.html 로 다음 내용과 함께 보내줌
        title: '내 정보',
        user : user,});
  });

  module.exports = router;