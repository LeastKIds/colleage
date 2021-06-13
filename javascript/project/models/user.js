const Sequelize = require('sequelize'); // 시퀄라이즈 가져오기

module.exports = class User extends Sequelize.Model {
  static init(sequelize) {
    return super.init({
      email: {  // email 행을 만듬
        type: Sequelize.STRING(40), // 문자열에 최대 40글자
        allowNull: true,  // Null 허용
        unique: true, // 유니크 값
      },
      nick: { // nick 행을 만듬
        type: Sequelize.STRING(15), // 문자열에 최대 15글자
        allowNull: false, // Null 값 허용 안 함
      },
      password: { // password 행을 만듬
        type: Sequelize.STRING(100),  // 문자열에 최대 100글자 (암호화 때문에)
        allowNull: true,  // Null 값 허용 
      },
      provider: { // provider 행을 만듬. 이 아이디의 상태를 보여줌(카카오, 로컬)
        type: Sequelize.STRING(10), // 문자열에 최대 10글자
        allowNull: false, // Null값 허용 안함
        defaultValue: 'local',  // 기본 값 local
      },
      snsId: {  // snsId 행을 만듬. 아이디에 카카오도 등록 되어 있으면 설정됨
        type: Sequelize.STRING(30), // 문자열에 최대 30글자
        allowNull: true,  // Null값 허용
      },
      introduction : {  // introduction 행을 만듬.
        type : Sequelize.STRING(400), // 문자열에 최대 400글자
        allowNull : true, // Null 값 허용
      }
    }, {
      sequelize,  // model/index.js에서 연결 됨
      timestamps: false,  // createAt, updateAt 생성 안 함
      underscored: false, // 카멜 표기법
      modelName: 'User',  // 노드에서 쓰일 이름
      tableName: 'users', // 데이터베이스에서 쓰일 이름
      paranoid: true, // deleteAt 생성. 백업용
      charset: 'utf8',  // 한국어 가능. 이모티콘은 안 됨
      collate: 'utf8_general_ci',
    });
  }

  static associate(db) {
    db.User.hasMany(db.Post);
    db.User.hasMany(db.Comment);
    db.User.belongsToMany(db.User, {
      foreignKey: 'followingId',
      as: 'Followers',
      through: 'Follow',
    });
    db.User.belongsToMany(db.User, {
      foreignKey: 'followerId',
      as: 'Followings',
      through: 'Follow',
    });

    db.User.hasOne(db.Introduction);
  }
};
