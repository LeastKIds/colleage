const Sequelize = require('sequelize');
const env = process.env.NODE_ENV || 'development';
const config = require('../config/config')[env];
const User = require('./user');
const Post = require('./post');
const Comment = require('./comment');
const Introduction = require('./introduction');

const db = {};
const sequelize = new Sequelize(
  config.database, config.username, config.password, config,
);

db.sequelize = sequelize;
db.User = User;
db.Post = Post;
db.Comment = Comment;
db.Introduction = Introduction;

User.init(sequelize);
Post.init(sequelize);
Comment.init(sequelize);
Introduction.init(sequelize);

User.associate(db);
Post.associate(db);
Comment.associate(db);
Introduction.associate(db);

module.exports = db;
