const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

const { Post, User,  Comment } = require('../models');
const { isLoggedIn } = require('./middlewares');
const { addListener } = require('process');
const { userInfo } = require('os');

const router = express.Router();

router.get('/', isLoggedIn, async(req,res,next) => {
    return res.render('profileAlter',{
        title : '자기소개 수정',
       
    });
});

router.post('/alter', isLoggedIn, async(req,res,next) => {
    await User.update({
        introduction : req.body.content,
    }, {
        where : {id : req.user.id },
    });

    const user = await User.findOne({
        where : { id : req.user.id },
    });
    
    return res.render('profile', {
        user : user,
    })
})
module.exports = router;