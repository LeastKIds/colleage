package j210305.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;

class MyPanel1 extends JPanel
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    ArrayList<Shape> shapeArray = new ArrayList<>();

    public MyPanel1()
    {
        Shape s;

        // s=new Rectangle2D.Float(10,10,70,80);
        // shapeArray.add(s);
        // s=new RoundRectangle2D.Float(110,10,70,80,20,20);
        // shapeArray.add(s);
        // s=new Ellipse2D.Float(210,10,80,80);
        // shapeArray.add(s);
        //s=new Arc2D.Float(310,10,80,80,90,90,Arc2D.OPEN);
        // shapeArray.add(s);
        // s=new Arc2D.Float(410,10,80,80,0,180, Arc2D.CHORD);
        // shapeArray.add(s);
        // s=new Arc2D.Float(510,10,80,80,45,90,Arc2D.PIE);
        // shapeArray.add(s);

    }
    
    public void paintComponent(Graphics g)
    {
        //super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3));
        GradientPaint gp=new GradientPaint(0,10,Color.WHITE,0,70,Color.RED);
        g2.setPaint(Color.RED);
        g2.fill(new Rectangle2D.Float(10,10,70,80));
        g2.setPaint(gp);
        g2.fill(new RoundRectangle2D.Float(110,10,70,80,20,20));
        g2.setPaint(Color.RED);
        g2.fill(new Ellipse2D.Float(210,10,80,80));
        g2.setPaint(gp);
        g2.fill(new Arc2D.Float(310,10,80,80,45,240,Arc2D.OPEN));
        g2.setPaint(Color.RED);
        g2.fill(new Arc2D.Float(410,10,80,80,45,240,Arc2D.CHORD));
        g2.setPaint(gp);
        g2.fill(new Arc2D.Float(510,10,80,80,54,240,Arc2D.PIE));

    }
}

public class FillShapes extends JFrame{
    public FillShapes()
    {
        this.setSize(600,130);
        this.setTitle("Java 2D Fill Shapes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new MyPanel1();
        this.add(panel);
        this.setVisible(true);
    }
    public static void main(String[] args)
    {
        new FillShapes();
    }
}
