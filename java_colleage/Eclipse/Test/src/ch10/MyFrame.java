package ch10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel1 extends JPanel implements ActionListener{
	boolean flag=false;
	private int light_number=0;
	
	public MyPanel1()
	{
		this.setLayout(new BorderLayout());
		JButton b=new JButton("traffic light turn on");
		b.addActionListener(this);
		this.add(b,BorderLayout.SOUTH);
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(100, 100, 100, 100);
		g.drawOval(100, 200, 100, 100);
		g.drawOval(100,300,100,100);
		
		if(light_number ==0)
		{
			g.setColor(Color.RED);
			g.fillOval(100, 100, 100, 100);
		}
		else if(light_number ==1)
		{
			g.setColor(Color.GREEN);
			g.fillOval(100, 200, 100, 100);
		}
		else
		{
			g.setColor(Color.YELLOW);
			g.fillOval(100, 300, 100, 100);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(++light_number >=3)
		{
			light_number=0;
		}
		repaint();
	}
}


public class MyFrame extends JFrame
{
	public MyFrame()
	{
		this.add(new MyPanel1());
		this.setSize(300,500);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new MyFrame();
	}
}