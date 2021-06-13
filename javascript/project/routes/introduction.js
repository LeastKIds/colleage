const express = require('express');
const multer = require('multer');
const path = require('path');
const fs = require('fs');

const { User, Introduction } = require('../models');
const { isLoggedIn } = require('./middlewares');
const { addListener } = require('process');
const { userInfo } = require('os');

const router = express.Router();

// 이미지를 저장할 폴더가 있는 지 확인
try {
    fs.readdirSync('uploads');
  } catch (error) {
    console.error('uploads 폴더가 없어 uploads 폴더를 생성합니다.');
    fs.mkdirSync('uploads');
  }


router.get('/', isLoggedIn, async (req, res, next) => { // /introduction로 get 요청이 들어올시 로그인이 되어있으면 다음을 실행
    const introduction = await Introduction.findAll({ // introduction 테이블을 전체를 가져옴
    });

    res.render('introduction', {  // introduction.html로 introductions에 introduction으로 넘겨줌
      introductions : introduction,
    });
  });

  
  
  const upload = multer({ // 이미지 업로드
    storage: multer.diskStorage({ // 저장될 곳 지정
      destination(req, file, cb) {
        cb(null, 'uploads/'); // 저장 폴더. 없으면 오류
      },
      filename(req, file, cb) {
        const ext = path.extname(file.originalname);  // 파일 확장자 추출
        cb(null, path.basename(file.originalname, ext) + Date.now() + ext); // 고유한 파일로 만들기 위해 시간을 붙여 저장.
      },
    }),
    limits: { fileSize: 5 * 1024 * 1024 },  // 파일 사이즈
  });
  
  router.post('/img', isLoggedIn, upload.single('img'), (req, res) => { // /img로 post 요청이 들어올 시 로그인이 되어 있으면 이미지 올림.
    console.log(req.file);
    res.json({ url: `/img/${req.file.filename}` }); // axios로 왔기 때문에 json으로 대답함
  });
  
  const upload2 = multer();

  router.post('/', isLoggedIn, upload2.none(), async (req, res, next) => {  // /introduction으로 post 요청이 올시 로그인 되어 있으면 이미지 업로드함
    try {
      console.log(req.user);
      console.log('---------------------------');
      console.log(req.body.check);
      if(req.body.check == 1) // 만약 새로 만들기를 했을 경우
      {
        console.log('check 1이 실행중');
        const introduction = await Introduction.create({  // introduction 테이블에 새로운 행을 만듬
        content: req.body.content,  // 프론트로 부터 넘어온 값들
        img: req.body.url,
        UserId: req.user.id,
        title : req.body.title,
        });
      } else  // 수정하기를 눌렀을 경우 (check =2 )
      {
        console.log('check 2가 실행중');
        const introduction = await Introduction.update({  // introduction 테이블을 수정함
          title : req.body.title,
          content: req.body.content,
          img: req.body.url,
        }, {where : { id : req.body.postId }} );  // 해당 행을 수정함

      }
      
      res.redirect('introduction'); // introduction.html 으로 보내줌
    } catch (error) {
      console.error(error);
      next(error);
    }
  });

  router.get('/create', isLoggedIn, async(req,res,next) => {  // /introduction/create로 get요청이 올 경우 로그인되어 있을 시 다음을 실행
    res.render('introductionAlter', { // 다음 내용을 담아서 introduction.html로 보냄
      title : '현지 학기제 작성/수정',
      check : 1,  // 현재 새로 작성중임을 체크함
    });
  });

router.get('/alter', isLoggedIn, async(req,res,next) => { // /introduction/alter'로 get요청이 올 경우 로그인 되어 있을시 다음을 실행
  const introduction = await Introduction.findOne({ // introduction 테이블에서 해당 행을 가져옴
    where : { id : req.query.postId },  // 해당 행을 가져오는 곳
  });
  res.render('introductionAlter', { // introductionAlter.html 로 다음 내용을 담아서 보내줌
    title : 'Q&A',
    post : introduction,
    check : 2,  // 수정 함을 체크함
  });
});

router.get('/delete', isLoggedIn, async(req,res,next) => {
  await Introduction.destroy({
    where : { id : req.query.postId },
  });
  res.redirect('/introduction');
})
module.exports = router;
