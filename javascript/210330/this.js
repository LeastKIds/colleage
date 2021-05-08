console.log(this);
console.log(this === module.exports);
console.log(this===exports);

// === : 값 과 타입(데이터형, data type)이 같아야 true

function wahtIsThis(){
    console.log('함수',this===exports,this===global)
}

wahtIsThis();