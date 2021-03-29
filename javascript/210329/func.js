const {odd, even} = require('./var');
//  구조분해 할당

function checkOddOrEven(num){
    if(num%2){
        return odd;
    }
    return even;
}

module.exports=checkOddOrEven;