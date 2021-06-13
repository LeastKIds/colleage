const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

const { Post, User, Comment } = require('../models');
const { isLoggedIn } = require('./middlewares');
const { addListener } = require('process');

const router = express.Router();



router.post('/create',isLoggedIn, async(req,res,next) => {  // /create로 post 요청시 로그인 되어 있으면 다음을 실행
  try {

    const content = await Comment.create({  // comment 데이터베이스의 행을 생성
      comment : req.body.content,
      PostId : req.body.postId,
      UserId : req.user.id,
      nick : req.user.nick,
    });

    const comment = await Comment.findAll({ // 그리고 생성된 결과물을 가져옴
      include: {
        model: Post,
      },
      where : { PostId : req.body.postId },
      order: [['createdAt']], // 올름차순
    });


    const post = await Post.findOne({ // post 테이블에서 하나의 값을 찾음
      include: {
        model: User,
        attributes: ['id', 'nick'],
      },
      where : { id : req.body.postId }, // 찾는 위치
    });

    const user = await User.findOne({ // user 테이블에서  정보를 하나 찾음
      include : {
        model : Comment,
      },
      where : { id : req.body.userId }, // 찾는 위치
    });


    res.render('postTitle' , {  // postTitle.html로 다음 내용과 함께 보내줌
      title : '게시판',
      twit : post,
      comments : comment,
      commentId : user,
      userId : req.user.id,
      
    });
  } catch (error) {
    console.error(error);
    next(error);
  }
  
  
  
});

router.get('/create', isLoggedIn, async(req,res,next) => {  // /create로 get 요청시 로그인되어있으면 다음 내용을 실행

  res.render('postCreate', {  // postCreate.html과 함께 보내줌
    title : 'Q&A',
    check : 1,  // 새로 생성중임을 체크
  });
});

router.post('/delete', isLoggedIn, async(req,res,next) => { // /delete로 post 요청시 로그인 되어있으면 다음이 실행됨

  Comment.destroy({ // 해당 내용을 지움
    where : { PostId : req.body.postId },
  }),

  Post.destroy({  // 해당 내용을 지움
    where : { id : req.body.postId },
  });

  res.redirect('/');  // 메인으로 보내줌
});

router.post('/alter', isLoggedIn, async(req,res,next) => {  // /alter로 post 요청이 올시 로그인되어 있으면 다음 내용을 실행
  const post = await Post.findOne({ // post 에서 하나의 결과 값을 찾음
    where : { id : req.body.postId } ,  
  });

  res.render('postCreate', {  // postCreate.html로 해당 내용과 함께 넘겨줌
    title : 'Q&A',
    post : post,
    check : 2,  // 수정임을 확인
  });
});

router.get('/:id',isLoggedIn, async (req,res,next) => { // /:id 로 get 요청이 들어올 시 로그인 되어 있으면 다음 내용을 실행
  
   try {
      const post = await Post.findOne({ // post 테이블의 결과값 하나를 가져옴
        include: {  
          model: User,  // User 테이블과 조인
          attributes: ['id', 'nick'],
        },
        where : { id : req.query.twitId },
      });

      const comment = await Comment.findAll({ // comment 테이블의 결과값을 가져옴
        include: {
          model: Post,  // post 테이블과 조인
        },
        order: [['createdAt']], // 오름 차순
        where : { PostId : req.query.twitId }
      });
      res.render('postTitle', { // postTitle.html로 다음 결과물과 함께 보냄
         title: '게시판',
         twit : post ,
        comments : comment,
        userid : req.user.id,
        
       });

       

    } catch (err) {
      console.error(err);
      next(err);
    }   
});


module.exports=router;