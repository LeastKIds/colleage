package ch10;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventTest extends JFrame{
	public MouseEventTest()
	{
		this.setSize(300,300);
		this.setTitle("마우스로 사각형 그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new MyPanel2());
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		MouseEventTest s= new MouseEventTest();
	}
}

class Rectangle2
{
	int x,y,w,h;
}

class MyPanel2 extends JPanel implements MouseListener
{
	BufferedImage img=null;
	int img_x=0, img_y=0;
	ArrayList<Rectangle2> arr=new ArrayList<>();
//	Rectangle2[] array =new Rectangle2[100];
	int index=0;
	
	public MyPanel2()
	{
		this.addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(Rectangle2 r : arr)
			if(r!=null)
					g.drawRect(r.x,r.y , r.w, r.h);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(index > 100)
			return;
//		array[index] = new Rectangle2();
//		array[index].x = e.getX();
//		array[index].y=e.getY();
//		array[index].w=50;
//		array[index].h=50;
		
		arr.add(new Rectangle2());
		arr.get(index).x=e.getX();
		arr.get(index).y=e.getY();
		arr.get(index).w=50;
		arr.get(index).h=50;
		index ++;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}