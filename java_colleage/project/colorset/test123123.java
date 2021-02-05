package project.colorset;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.*;

public class test123123 extends JFrame
{
    public static void main(String[] args)
    {
        int count=0;
        int number=0;
        int k=0;
        while(true)
        {
            System.out.println(k);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            k++;
            if(k==5)
                break;
        }



    }

   
    
}

    

