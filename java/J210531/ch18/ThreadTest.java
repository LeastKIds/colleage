package J210531.ch18;

public class ThreadTest {
    public static void main(String[] args)
    {
        Thread c1 = new Counter(1);
        Thread c2 = new Counter(2);
        // Runable
        c1.start(); // 새로운 스레드로 실행
        c2.start(); // 새로운 스레드로 실행


        System.out.println("main Thread 종료");
    }
}

class Counter extends Thread{
    private int start;
    public Counter(int start)
    {
        this.start = start;
    }
    public void run() {
        for(int i= start; i<start+10; i++)
        {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
