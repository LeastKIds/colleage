package ch10;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



class MyPanel extends JPanel
{
	BufferedImage img = null;
	int img_x = 100, img_y = 100;
	
	public MyPanel()
	{
		try {
			img=ImageIO.read(new File("car.jpg"));
		}catch (IOException e) {
			System.out.println("no image");
			System.out.println(System.getProperty("user.dir"));
			System.exit(1);
		}
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyCode=e.getKeyCode();
				switch(keyCode)
				{
				case KeyEvent.VK_UP :
					img_y-=10;
					System.out.println("y : " + img_y);
					break;
				case KeyEvent.VK_DOWN :
					img_y +=10;
					System.out.println("y : " + img_y);
					break;
				case KeyEvent.VK_LEFT :
					img_x -=10;
					System.out.println("x : " + img_x);
					break;
				case KeyEvent.VK_RIGHT :
					img_x +=10;
					System.out.println("x : " + img_x);
					break;
				}
				
				repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		this.requestFocus();
		this.setFocusable(true);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}
}

public class CarGameTest extends JFrame
{
	public CarGameTest()
	{
		this.setSize(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new MyPanel());
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new CarGameTest();
		
	}
}
