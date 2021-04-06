const {
    Worker,isMainThread, parentPort,
} = require('worker_threads');

if(isMainThread)
{
    const worker = new Worker(__filename);
    worker.on('message',message => console.log('from worker',message)); // on : 'message' 값이 오면 뒤에 문장이 실행
    worker.on('exit', () => console.log('worker exit'));
    worker.postMessage('ping');
}else
{
    parentPort.on('message', (value) => 
    {
        console.log('from parent',value);
        parentPort.postMessage('pong');
        parentPort.close();
    });
}