package ch10;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scribble extends JFrame{
	public Scribble()
	{
		this.setSize(300,300);
		this.setTitle("마우스로 그림그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new MyPanel3());
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Scribble();
	}
}

class Point
{
	int x,y;
}

class MyPanel3 extends JPanel implements MouseMotionListener
{
	private int index = 0;
	ArrayList<Point> arr=new ArrayList<>();
//	Point[] array=new Point[1000];
	
	public MyPanel3()
	{
		this.addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
//		int x=e.getX();
//		int y=e.getY();
//		if(index > 1000)
//			return;
		
//		array[index] = new Point();
//		array[index].x= e.getX();
//		array[index].y= e.getY();
		
		arr.add(new Point());
		arr.get(index).x=e.getX();
		arr.get(index).y=e.getY();
		index ++;
		System.out.println(index);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for(Point p : arr)
			if(p != null)
					g.drawRect(p.x, p.y, 1, 1);
	}
}