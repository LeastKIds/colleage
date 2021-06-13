const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

const { Post  } = require('../models');
const { isLoggedIn } = require('./middlewares');

const router = express.Router();

// 이미지를 다운로드 할 폴더 생성
try {
  fs.readdirSync('uploads');
} catch (error) {
  console.error('uploads 폴더가 없어 uploads 폴더를 생성합니다.');
  fs.mkdirSync('uploads');
}

// 이미지 업로드
const upload = multer({
  storage: multer.diskStorage({ // 저장 공간 만들기
    destination(req, file, cb) {
      cb(null, 'uploads/'); // 해당 위치에 저장. 없으면 오류
    },
    filename(req, file, cb) {
      const ext = path.extname(file.originalname);  // 파일 확장자
      cb(null, path.basename(file.originalname, ext) + Date.now() + ext); // 겹치지 않도록 현재 시간 넣어서 저장.
    },
  }),
  limits: { fileSize: 5 * 1024 * 1024 },  // 올리는 내용물
});

router.post('/img', isLoggedIn, upload.single('img'), (req, res) => { // /img로 post 요청이 들어올 시 로그인이 되어있으면 다음을 실행.
  console.log(req.file);
  res.json({ url: `/img/${req.file.filename}` }); // axios로 요청 받아서 json으로 응답
});

const upload2 = multer();
router.post('/', isLoggedIn, upload2.none(), async (req, res, next) => {  // '/'으로 post 요청시 로그인이 되어있으면 다음을 실행
  try {
    console.log(req.user);
    
    if(req.body.check ==1 ) // 새로 만들기일 경우
    {
      const post = await Post.create({  // 새로운 행을 만듬
        title : req.body.title,
        content: req.body.content,
        img: req.body.url,
        UserId: req.user.id,
      });
    }else if(req.body.check ==2 ) // 수정하기일 경우
    {
      const post= await Post.update({ // 수정 함
        title : req.body.title,
        content: req.body.content,
        img: req.body.url,
      }, {where : { id : req.body.postId }} );
    }
      
    
    
    
    res.redirect('/');  // 해당 페이지로 보내줌
  } catch (error) {
    console.error(error);
    next(error);
  }
});

module.exports = router;
