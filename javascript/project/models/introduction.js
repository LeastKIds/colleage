const Sequelize = require('sequelize'); // 시퀄라이즈 가져오기

module.exports = class Introduction extends Sequelize.Model {
  static init(sequelize) {
    return super.init({
      title: {  // title 행을 만듬
        type: Sequelize.STRING(20), // 문자열에 최대 20글자
        allowNull: false, // null 허용 안함
      },
      content: {  // content 행을 만듬
        type: Sequelize.STRING(400),  // 문자열에 최대 400글자
        allowNull: false, // null 허용 안함
      },
      img: {  // img 행을 만듬
        type: Sequelize.STRING(200),  // 문자열에 최대 200글자
        allowNull: true,  // null 허용
      },
    }, {
      sequelize,  // model/index.js에서 연결 됨
      timestamps: true, // createAt, updateAt를 만들어 줌
      underscored: false, // 카멜 표기법으로 함
      modelName: 'Introduction',  // 노드에서 사용할 이름
      tableName: 'introductions', // 데이터베이스에서 사용할 이름
      paranoid: false,  // deleteAt를 만듬. 백업용
      charset: 'utf8mb4', // 한국어에 이모티콘 까지 가능
      collate: 'utf8mb4_general_ci',
    });
  }

  // 테이블간 관계 설정
  static associate(db) {
      db.Introduction.belongsTo(db.User); // User와 1 : 1
  }
};
