package j210126.ch09;

import javax.swing.Timer;
import java.awt.event.*;

public class Main4 implements ActionListener{
    private int minute=0;

    public static void main(String[] args)
    {
        Main4 listener=new Main4();
        Timer timer=new Timer(1000, listener);
        timer.start();  //쓰레드(Thread) : 실행의 흐름
                        //timer는 멀티쓰레드로써 이 곳을 분기점으로 멀티로 돌아간다
                        //timer쓰레드와 메인 쓰레드가 따로 실행되다가 main쓰레드가 종료되면
                        //timer쓰레드도 같이 종료된다
        
        for(int i=0; i<30; i++) //timer와는 독립적으로 실행. timer가 돌아갈 시간을 벌어주는 코드
        {
            try{
            Thread.sleep(1000); //이 시간 만큼 기다린다.
            } catch(InterruptedException ie)
            {
                System.out.println("Exception 오류가 발생했습니다.");
            }
        }

        System.out.println("메인 종료합니다...");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Elapsed : " + ++minute);

    }
}
