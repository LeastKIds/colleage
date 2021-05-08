const url = require('url');
const querystring=require('querystring');

const parseURL=url.parse('http://www.gilbut.co.kr/?page=3&limit=10&category=nodejs&category=javascript');
const query=querystring.parse(parseURL.query);
console.log('querystring.parse() : ',query);
console.log('querystring.stringify() : ',querystring.stringify(query));