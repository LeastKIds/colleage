package j210202.ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawRactangle extends JFrame{
    public DrawRactangle()
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

class Rectangle
{
    int x,y,w,h;
    public Rectangle(int x, int y, int w, int h)
    {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }
}

class MyPanel extends JPanel implements MouseListener, MouseMotionListener
{

    Rectangle[] rectangles=new Rectangle[100];
    int index=0;

    public MyPanel()
    {
        // this.addMouseListener(this);
        this.addMouseMotionListener(this);


    }
        
    

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

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

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        // if(index >= rectangles.length)  return;
        // rectangles[index] =new Rectangle(e.getX(),e.getY(),2,2);
        // index++;
        // repaint();

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

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        if(index >= rectangles.length)  return;
        rectangles[index] =new Rectangle(e.getX(),e.getY(),2,2);
         index++;
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
