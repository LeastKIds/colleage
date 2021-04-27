package ch09;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//class MyClass implements ActionListener
//{
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("beep");
//	}
//
//}




public class CallbackTest {
	public static void main(String[] args)
	{
//		ActionListener listener =new MyClass();
//		Timer t=new Timer(1000, listener);
		Timer t=new Timer(1000,event -> System.out.println("beep"));
		t.start();
		for(int i=0; i<1000; i++)
		{
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
		}
	}
	
}
