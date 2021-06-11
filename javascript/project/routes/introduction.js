const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

const { User, Introduction } = require('../models');
const { isLoggedIn } = require('./middlewares');
const { addListener } = require('process');
const { userInfo } = require('os');

const router = express.Router();


try {
    fs.readdirSync('uploads');
  } catch (error) {
    console.error('uploads 폴더가 없어 uploads 폴더를 생성합니다.');
    fs.mkdirSync('uploads');
  }


router.get('/', isLoggedIn, async (req, res, next) => {
    const introduction = await Introduction.findAll({
    });

    res.render('introduction', {
      introductions : introduction,
    });
  });

  
  
  const upload = multer({
    storage: multer.diskStorage({
      destination(req, file, cb) {
        cb(null, 'uploads/');
      },
      filename(req, file, cb) {
        const ext = path.extname(file.originalname);
        cb(null, path.basename(file.originalname, ext) + Date.now() + ext);
      },
    }),
    limits: { fileSize: 5 * 1024 * 1024 },
  });
  
  router.post('/img', isLoggedIn, upload.single('img'), (req, res) => {
    console.log(req.file);
    res.json({ url: `/img/${req.file.filename}` });
  });
  
  const upload2 = multer();

  router.post('/', isLoggedIn, upload2.none(), async (req, res, next) => {
    try {
      console.log(req.user);
      console.log('---------------------------');
      console.log(req.body.check);
      if(req.body.check == 1)
      {
        console.log('check 1이 실행중');
        const introduction = await Introduction.create({
        content: req.body.content,
        img: req.body.url,
        UserId: req.user.id,
        title : req.body.title,
        });
      } else
      {
        console.log('check 2가 실행중');
        const introduction = await Introduction.update({
          title : req.body.title,
          content: req.body.content,
          img: req.body.url,
        }, {where : { id : req.body.postId }} );

      }
      
      
      // res.render('introduction', {
      //   title : '현지 학기제 작성/수정 ',
      //   user : req.user.id,
      //   introductions : introduction,
      // });
      res.redirect('introduction');
    } catch (error) {
      console.error(error);
      next(error);
    }
  });

  router.get('/create', isLoggedIn, async(req,res,next) => {
    res.render('introductionAlter', {
      title : '현지 학기제 작성/수정',
      check : 1,
    });
  });

router.get('/alter', isLoggedIn, async(req,res,next) => {
  const introduction = await Introduction.findOne({
    where : { id : req.query.postId },
  });
  res.render('introductionAlter', {
    title : 'Q&A',
    post : introduction,
    check : 2,
  });
});
module.exports = router;
