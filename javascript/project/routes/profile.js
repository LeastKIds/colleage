const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

const { Post, User,  Comment } = require('../models');
const { isLoggedIn } = require('./middlewares');
const { addListener } = require('process');

const router = express.Router();


router.get('/', isLoggedIn, async (req, res) => {
  
    const user = await User.findOne({
        where : {id : req.user.id},
    });

    return res.render('profile', { 
        title: '내 정보',
        user : user,});
  });

  module.exports = router;