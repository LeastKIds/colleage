const express = require('express');
const { isLoggedIn, isNotLoggedIn } = require('./middlewares');
const { Post, User  } = require('../models');
const { addListener } = require('nodemon');
const { Op } = require('sequelize');

const router = express.Router();

router.use((req, res, next) => {  // 모든 요청이 들어올 경우
  res.locals.user = req.user; // 프론트로 현재 유저의 정보를 넘겨줌
  next(); // 다음 미들 웨어로 
});


router.get('/join', isNotLoggedIn, (req, res) => {  // /join으로 get요청이 들어올 시 로그인이 되어 있다면 다음을 실행
  res.render('join', { title: '회원가입' });  // join.html로 다음 내용을 담아 보냄
});

router.get('/', async (req, res, next) => { // /으로 get요청이 들어올 시 다음을 실행
  try {
    const posts = await Post.findAll({  // post 테이블의 모든 정보를 가져옴
      include: {
        model: User,  // user와 조인을 함
        attributes: ['id', 'nick'], // id, nick 열을 가져옴
      },
      order: [['createdAt', 'DESC']], // 생성날짜 내림차순으로 정렬
    });
    res.render('main', {  // main.html파일로 다음 내용을 담아 보냄
      title: '메인화면',
      twits: posts,
      check : 0, 
    });
  } catch (err) {
    console.error(err);
    next(err);
  }
});



router.post('/search', async(req,res,next) => { // /search로 post요청이 들어올 시 다음이 실행됨
  const keyword=req.body.search;  // 프론트에서 넘어온 데이터를 저장(검색기능)
  try{
    const post = await Post.findAll({ // Post 타이틀 검색
      where : {title : {[Op.like] : '%'+keyword+'%' } },
    });

    res.render('search',{ // serach.html로 다음 내용을 보내줌
      title : '검색 결과',
      twits : post,
    })
  } catch(error)
  {
    console.error(error);
    next(error);
  }

});



module.exports = router;
