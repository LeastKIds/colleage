const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

const { Post, User, Comment } = require('../models');
const { isLoggedIn } = require('./middlewares');
const { addListener } = require('process');

const router = express.Router();



router.post('/create',isLoggedIn, async(req,res,next) => {
  try {

    const content = await Comment.create({
      comment : req.body.content,
      PostId : req.body.postId,
      UserId : req.user.id,
      nick : req.user.nick,
    });

    const comment = await Comment.findAll({
      include: {
        model: Post,
      },
      where : { PostId : req.body.postId },
      order: [['createdAt']],
    });


    const post = await Post.findOne({
      include: {
        model: User,
        attributes: ['id', 'nick'],
      },
      where : { id : req.body.postId },
    });

    const user = await User.findOne({
      include : {
        model : Comment,
      },
      where : { id : req.body.userId },
    });

   

    res.render('postTitle' , {
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

router.get('/create', isLoggedIn, async(req,res,next) => {

  res.render('postCreate', {
    title : 'Q&A',
    check : 1,
  });
});

router.post('/delete', isLoggedIn, async(req,res,next) => {

  Comment.destroy({
    where : { PostId : req.body.postId },
  }),

  Post.destroy({
    where : { id : req.body.postId },
  });

  res.redirect('/');
});

router.post('/alter', isLoggedIn, async(req,res,next) => {
  const post = await Post.findOne({
    where : { id : req.body.postId } ,
  });

  res.render('postCreate', {
    title : 'Q&A',
    post : post,
    check : 2,
  });
});

router.get('/:id',isLoggedIn, async (req,res,next) => {
  
   try {
      const post = await Post.findOne({
        include: {
          model: User,
          attributes: ['id', 'nick'],
        },
        where : { id : req.query.twitId },
      });

      const comment = await Comment.findAll({
        include: {
          model: Post,
        },
        order: [['createdAt']],
        where : { PostId : req.query.twitId }
      });
      res.render('postTitle', { 
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