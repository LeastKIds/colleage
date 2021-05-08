const express=require('express');

const router=express.Router();

router.get('/', (req,res) => {
    res.send('Hllo, User');
});

module.exports=router;