package j210204.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SnowManFace  extends JFrame{
    public SnowManFace()
    {
        this.setSize(280,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("눈사람 얼굴");
        this.add(new MyDrawingFacePanel());
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        JFrame frame=new SnowManFace();
    }
}

class MyDrawingFacePanel extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillOval(20,30,200,200);

        g.setColor(Color.black);
        g.drawArc(60,80,50,50,-180,180);
        g.drawArc(150,80,50,50,-180,180);
        g.drawArc(70,150,100,70,-180,-180);
    }
}