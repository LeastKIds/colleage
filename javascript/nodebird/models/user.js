const Sequelize = require('sequelize');

module.exports = class User extends Sequelize.Model {
    static init(sequelize) {
        return super.init({ // init : 컬럼 생성
            email : {
                type : Sequelize.STRING(40),
                allowNull : true,
                unique : true,
            },
            nick : {
                type : Sequelize.STRING(15),
                allowNull : false,
            },
            password : {
                type : Sequelize.STRING(100),
                allowNull : true,
            },
            provider : {    // 카카오로 로그인했는지, 로컬로 로그인했는지
                type : Sequelize.STRING(10),
                allowNull : false,
                defaultValue : 'local',
            },
            snsId : {   // SNS 로그인 서비스 이용시 SNS ID를 저장
                type : Sequelize.STRING(30),
                allowNull : true,
            },
        }, {
            sequelize,
            timestamps : true,  // createdAt, updateAt, deleteAt 컬럼으로 생성
            underscored : false,    // created_at 이 아니라 createAt으로 표기
            modelName : 'User',
            tableName : 'users',
            paranoid : true,    // deletedAt 컬럼 생성
            charset : 'utf8',
            collate : 'utf8_general_ci'
        });
    }

    static associate(db) {  // 다른 모델(table)과의 관계
        db.User.hasMany(db.Post);   // 1:N의 관계
            // user.getPosts(), user.addPosts() 메소드 자동 사용 가능하게 됨.
        db.User.belongsToMany(db.User, {    // 팔로워 : 팔로잉 관계 -- N:M
            foreignkey : 'followingId', // userId를 외래키 값으로 참조
            as : 'Followers',
            through : 'Follow', // db.seqeulize.models.Follow라 모델 사용 가능
        });
        db.User.belongsToMany(db.User, {
            foreignkey : 'followerId',  // userId를 외래키 값으로 참조
            as : 'Followings',
            through : 'Follow', // user.getFollowers(), user.getFollowings()
        });
    }
};