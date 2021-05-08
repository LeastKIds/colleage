package j210204.ch11;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.*;
import java.awt.*;

public class BasicPaint {
    public static void main(String[] args)
    {
        JFrame frame=new JFrame("그래픽 기초 프로그램");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MyPanel());

        frame.setSize(300,200);
        frame.setVisible(true);
    }
}

class MyPanel extends JPanel
{
    private int squareX=50;
    private int squareY=50;
    private int squareW=20;
    private int squareH=20;

    public MyPanel()
    {
        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e)
                {
                    moveSquare(e.getX(), e.getY());
                }
            });

        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e)
            {
                moveSquare(e.getX(), e.getY());
            }
        });
    }

    private void moveSquare(int x, int y)
    {
        int OFFSET=1;
        if((squareX!=x) || (squareY!=y))
        {
            repaint(squareX,squareY,squareW + OFFSET, squareH + OFFSET);
            squareX=x;
            squareY=y;
            repaint(squareX,squareY,squareW + OFFSET, squareH + OFFSET);
        }
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawString("마우스를 클릭하면 사각형이 그려집니다!",10,20);
        g.setColor(Color.RED);
        g.fillRect(squareX,squareY,squareW, squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX,squareY,squareW, squareH);
    }
}

