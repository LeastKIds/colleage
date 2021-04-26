const fs=require('fs').promises;

( async () => {
    try{
        const a = await fs.readFile('./readme.txt');
        console.log('1번');
        await fs.readFile('./readme.txt');
        console.log('2');
        await fs.readFile('./readme.txt');
        console.log('3');    
    }catch (err){
        console.error(err);
    }
    
}) () ;