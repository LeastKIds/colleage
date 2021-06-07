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
      const introduction = await Introduction.create({
        content: req.body.content,
        img: req.body.url,
        UserId: req.user.id,
        title : req.body.title,
      });
      
      res.redirect('introduction');
    } catch (error) {
      console.error(error);
      next(error);
    }
  });


module.exports = router;
