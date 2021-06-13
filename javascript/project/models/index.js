const Sequelize = require('sequelize'); // 시퀄라이즈 연결
const env = process.env.NODE_ENV || 'development';  // 개발용인지 아닌지.
const config = require('../config/config')[env];  // config에서 데이터베이스, 계정 등을 가져옴
const User = require('./user'); // model/user.js를 가져옴
const Post = require('./post'); // model/post.js를 가져옴
const Comment = require('./comment'); // model/post.js를 가져옴
const Introduction = require('./introduction'); // model/comment.js를 가져옴

const db = {};  // 데이터베이스를 담을 공간
const sequelize = new Sequelize(  // 데이터베이스를 연결하는 곳
  config.database, config.username, config.password, config,
);

// db 변수에 데이터베이스 내용물을 담음
db.sequelize = sequelize;
db.User = User;
db.Post = Post;
db.Comment = Comment;
db.Introduction = Introduction;

// 데이터베이스 설정을 적용
User.init(sequelize);
Post.init(sequelize);
Comment.init(sequelize);
Introduction.init(sequelize);

// 테이블간 관계 설정
User.associate(db);
Post.associate(db);
Comment.associate(db);
Introduction.associate(db);
// 밖으로 내보내기
module.exports = db;
