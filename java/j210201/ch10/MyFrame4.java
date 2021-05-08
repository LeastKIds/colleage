package j210201.ch10;

import javax.swing.*;

import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;

import javax.imageio.*;

class MyPanel extends JPanel
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    BufferedImage img = null;
    int img_x=0, img_y=0;

    public MyPanel()
    {
        try{
            img=ImageIO.read(new File("./j210201/ch10/car.jpg"));
        } catch(IOException e){
            System.out.println("no image");
            System.out.println(System.getProperty("user.dir"));
            System.exit(1);
        }
        
        addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
                
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
                img_x=e.getX();
                img_y=e.getY();
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
            
        });
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img,img_x,img_y,null);
    }
}
public class MyFrame4 extends JFrame{
    public MyFrame4()
    {
        add(new MyPanel());
        setSize(300,500);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        MyFrame4 frame=new MyFrame4();
    }
}
