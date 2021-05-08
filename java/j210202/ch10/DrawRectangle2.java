package j210202.ch10;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.*;
import java.awt.event.*;

public class DrawRectangle2 extends JFrame{
    public DrawRectangle2()
    {
        this.setSize(300,300);
        this.setTitle("마우스로 사각형 그리기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new MyPanel());
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        JFrame frame=new DrawRactangle();
    }
}

class MyPanel2 extends JPanel
{

    Rectangle[] rectangles=new Rectangle[100];
    int index=0;

    public MyPanel2()
    {
        this.addMouseListener(new MyMouseListener());

    }

    @Override
        public void  paintComponent(Graphics g) {
            // TODO Auto-generated method stub
            super.paintComponent(g);
            for(Rectangle r : rectangles)
            {
                if(r==null) break;
    
                g.drawRect(r.x,r.y,1,1);
            }
        }
    
    class MyMouseListener extends MouseAdapter
    {


        


        @Override
        public void mousePressed(MouseEvent e)
        {
            super.mousePressed(e);

            if(index>=rectangles.length)    return;

            rectangles[index++]=new Rectangle(e.getX(), e.getY(),50,50);
            // r.x=e.getX();
            // r.y=e.getY();
            // r.w=50;
            // r.h=50;

            repaint();

        }
    }
   
}
