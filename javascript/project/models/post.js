const Sequelize = require('sequelize'); // 시퀄라이즈 가져옴

module.exports = class Post extends Sequelize.Model {
  static init(sequelize) {
    return super.init({
      title: {  // title 행을 만듬
        type: Sequelize.STRING(20), // 문자열에 최대 20글자
        allowNull: false, // null 허용 안함
      },
      content: {  // content 행을 만듬
        type: Sequelize.STRING(140),  // 문자열에 최대 140글자
        allowNull: false, // null 허용 안함
      },
      img: {  // img 행을 만듬
        type: Sequelize.STRING(200),  // 문자열에 최대 200글자
        allowNull: true,  // null 값 허용
      },
    }, {
      sequelize, // model/index.js에서 연결 됨
      timestamps: true, // createAt, updateAt 행을 만듬
      underscored: false, // 카멜표기법으로
      modelName: 'Post',  // 노드에서 쓸 이름
      tableName: 'posts', // 데이터베이스에서 쓸 이름
      paranoid: false,  // deleteAt를 만듬. 
      charset: 'utf8mb4', // 한글과 이모티콘 사용 가능
      collate: 'utf8mb4_general_ci',
    });
  }

  // 테이블간 관계 설정
  static associate(db) {
    db.Post.belongsTo(db.User); // User 테이블과 N : 1 관계
    db.Post.hasMany(db.Comment);  // Comment 테이블과 1 : N 관계
  }
};
