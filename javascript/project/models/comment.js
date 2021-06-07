const Sequelize = require('sequelize');

module.exports = class Comment extends Sequelize.Model {
    static init(sequelize) {
      return super.init({
        comment: {
          type: Sequelize.STRING(140),
          allowNull: false,
        },
        nick : {
          type: Sequelize.STRING(15),
          allowNull : false,
        }
        
      }, {
        sequelize,
        timestamps: true,
        underscored: false,
        modelName: 'Comment',
        tableName: 'Comments',
        paranoid: false,
        charset: 'utf8mb4',
        collate: 'utf8mb4_general_ci',
      });
    }
  
    static associate(db) {
      db.Comment.belongsTo(db.User);
      db.Comment.belongsTo(db.Post);
    }
  };