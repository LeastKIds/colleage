// 시퀄라이즈 불러오기
const Sequelize = require('sequelize');

// exports로 내보내기
module.exports = class Comment extends Sequelize.Model {
    static init(sequelize) {
      return super.init({
        comment: {  // coment 열을 만듬
          type: Sequelize.STRING(140), // 최대 글자 길이는 140. 문자열로
          allowNull: false, // null값 허용 안 함
        },
        nick : {  // nick 열을 만듬
          type: Sequelize.STRING(15), // 최대 글자 15. 문자열로
          allowNull : false,  // null값 허용 안함
        }
        
      }, {
        sequelize,  // model/index.js에서 연결 됨
        timestamps: true, // createAt, updateAt 칼럼을 추가.
        underscored: false, // 카멜 표기법으로
        modelName: 'Comment', // 노드에서 쓰는 이름
        tableName: 'Comments',  // 데이터베이스에서 쓰는 이름
        paranoid: false,  // deleteAt 칼럼의 유무를 결정. true면 삭제시 완전히 삭제하지 않고 백업용을 남겨놈
        charset: 'utf8mb4', // 한글 표기. mb4가 붙으면 이모티콘도 가능
        collate: 'utf8mb4_general_ci',
      });
    }
  
    // 테이블간의 관계 설정
    static associate(db) {
      db.Comment.belongsTo(db.User);  // User 테이블과 N : 1
      db.Comment.belongsTo(db.Post);  // Post 테이블과 N : 1
    }
  };