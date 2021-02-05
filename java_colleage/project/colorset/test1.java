package project.colorset;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

class test1 extends JFrame{
	JButton b1 = new JButton("버튼1");
	JButton b2 = new JButton("버튼2");
	JButton b3 = new JButton("버튼3");
	JButton b4 = new JButton("버튼4");
	JButton b5 = new JButton("버튼5");
	
	public test1(){
		// // 배치관리자 BorderLayout : 컴포넌트를 동,서,남,북,중앙에 배치
		// // 컨테이너에 add를 할 때, 위치를 지정해야함
		// // 프레임의 기본 배치관리자
		
		// // setLayout -> 배치 관리자를 지정
		// // 배치관리자 클래스의 인스턴스를 인수로 함
		// setLayout(new BorderLayout());
		// JPanel panel=new JPanel();
		// panel.add(b1, BorderLayout.SOUTH);
		// add(panel);
		
		// // add(b1, BorderLayout.EAST);	// == LINE_END
		// // add(b2, BorderLayout.WEST);	// == LINE_START
		// // add(b3, BorderLayout.SOUTH);	// == PAGE_END	
		// // add(b4, BorderLayout.NORTH);	// == PAGE_START
		// // add(b5, BorderLayout.CENTER);	
		
		// setSize(500,500);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setVisible(true);


		// JPanel p1=new JPanel();
		// p1.setLayout(new BorderLayout());
		// p1.setBackground(Color.YELLOW);
		// p1.setSize(500,500);
		// JPanel p2=new JPanel();
		// //p2.setLayout(new BorderLayout());
		// //p2.setBackground(Color.BLUE);
		// p2.setLayout(null);
		// p2.setSize(200,200);
		// JButton button=new JButton("dfafdadfafafasfasfdas");
		// button.setBounds(100,100,200,200);
		// JLabel label=new JLabel("zcvzxcvzxcvzvzvzx");
		// label.setBounds(300,300,100,100);
		// p2.add(button);
		// p2.add(label);
		// p1.add(p2);
		// // this.add(p1);

		// JLabel labe=new JLabel("test");
		// labe.setOpaque(true);
		// //labe.setForeground(new Color(0x990000FF,true));
		// labe.setBackground(new Color(255,0,0,100));


		// this.add(labe);

		// test2 t2=new test2();

		// this.add(t2.panel123123);

		JLabel label=new JLabel("test");
		label.setForeground(Color.YELLOW);

		JLabel label1=new JLabel();
		label1.setForeground(label.getForeground());
		this.add(label);

		this.setVisible(true);
		this.setSize(500,500);
		this.setResizable(false);
	}
	
	public static void main(String[] args)
	{
		test1 t=new test1();
	
	}
}
