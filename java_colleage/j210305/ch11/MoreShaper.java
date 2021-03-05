package j210305.ch11;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.geom.*;


public class MoreShaper extends JFrame {
    public MoreShaper()
    {
        this.setSize(600,130);
        this.setTitle("Java 2D Shapers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new MyPanel();
        this.add(panel);
        this.setVisible(true);
    }
    public static void main(String[] args)
    {
        new MoreShaper();
    }
}

class MyPanel extends JPanel
{
    ArrayList<Shape> shapeArray=new ArrayList<Shape>();
    public MyPanel()
    {
        Shape s;

        s=new Rectangle2D.Float(10,10,70,80);
        shapeArray.add(s);
        s=new RoundRectangle2D.Float(110,10,70,80,20,20);
        shapeArray.add(s);
        s=new Ellipse2D.Float(210,10,80,80);
        shapeArray.add(s);
        s=new Arc2D.Float(310,10,80,80,90,90,Arc2D.OPEN);
        shapeArray.add(s);
        s=new Arc2D.Float(410,10,80,80,0,180,Arc2D.CHORD);
        shapeArray.add(s);
        s=new Arc2D.Float(510,10,80,80,45,90,Arc2D.PIE);
        shapeArray.add(s);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
    }
}
