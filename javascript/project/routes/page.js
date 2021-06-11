const express = require('express');
const { isLoggedIn, isNotLoggedIn } = require('./middlewares');
const { Post, User  } = require('../models');
const { addListener } = require('nodemon');
const { Op } = require('sequelize');

const router = express.Router();

router.use((req, res, next) => {
  res.locals.user = req.user;
  next();
});


router.get('/join', isNotLoggedIn, (req, res) => {
  res.render('join', { title: '회원가입' });
});

router.get('/', async (req, res, next) => {
  try {
    const posts = await Post.findAll({
      include: {
        model: User,
        attributes: ['id', 'nick'],
      },
      order: [['createdAt', 'DESC']],
    });
    res.render('main', {
      title: '메인화면',
      twits: posts,
      check : 0,
    });
  } catch (err) {
    console.error(err);
    next(err);
  }
});



router.post('/search', async(req,res,next) => {
  const keyword=req.body.searchData;
  try{
    const post = await Post.findAll({
      where : {title : {[Op.like] : '%'+keyword+'%' } },
    });

    console.log('adfafdasdfafasfd');
    res.json({searchData : '잘왔습니다.'});
  } catch(error)
  {
    console.error(error);
    next(error);
  }

});



module.exports = router;
