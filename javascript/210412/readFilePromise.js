const fs = require('fs').promises;

// fs.readFile('./readme.txt')
// .then((data) => 
// {
//     console.log(data);
//     console.log(data.toString());
// })
// .catch((err) =>
// {
//     console.error(err);
// });

(async () =>
{
    try
    {
        let data=await fs.readFile('./readme.txt');
        console.log(data);
        console.log(data.toString());
    }catch(error)
    {
        console.error(error);
    }
})();