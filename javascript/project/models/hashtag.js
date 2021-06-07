const Sequelize = require('sequelize');
module.exports = class Hashtag extends Sequelize.Model {
    static init(sequelize) {
      return super.init({
        
        
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
    }
  };