package j210305.ch11;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class BezierCurve extends JFrame implements MouseListener, MouseMotionListener{

    private int[] xs={50,150,400,450,80,180,430,480};
    private int[] ys={200,50,300,200,230,80,330,230};
    private int drageIndex=-1;

    private MyPanel2 drawPanel;

    class MyPanel2 extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            // xs, ys 좌표를 이용해 베지오 좌표를 그린다
            g.setColor(Color.blue);
            g.fillRect(xs[0],ys[0],16,16);
            g.fillRect(xs[2],ys[2],16,16);
            g.fillRect(xs[4],ys[4],16,16);
            g.fillRect(xs[6],ys[6],16,16);
            g.setColor(Color.red);
            g.fillRect(xs[1],ys[1],16,16);
            g.fillRect(xs[3],ys[3],16,16);
            g.fillRect(xs[5],ys[5],16,16);
            g.fillRect(xs[7],ys[7],16,16);

            Graphics2D g2d=(Graphics2D) g;
            g2d.setColor(Color.black);
            GeneralPath path=new GeneralPath();
            path.moveTo(xs[0],ys[0]);
            path.curveTo(xs[1],ys[1],xs[2],ys[2],xs[3],ys[3]);
            g2d.draw(path);
            path.moveTo(xs[4],ys[4]);
            path.curveTo(xs[5],ys[5],xs[6],ys[6],xs[7],ys[7]);
            g2d.draw(path);

        }
    }

    public BezierCurve()
    {
        this.setSize(600,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("BezierCurve Demo");
        drawPanel=new MyPanel2();
        drawPanel.addMouseListener(this);
        drawPanel.addMouseMotionListener(this);
        this.add(drawPanel, BorderLayout.CENTER);

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        // 선택된 점 이 있는지 보고... drageIndex가 -1이 아닌지 보고 아니라면
        // 선택된 점의 x,y 좌표를 변경한다
        if(drageIndex!=-1)
        {
            xs[drageIndex] = e.getX();
            ys[drageIndex] = e.getY();
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
}

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        // 4개의 점 중에서 어떤 점이 선택되었는지를 체크
        drageIndex=-1;
        for(int i=0; i<8; i++)
        {
            Rectangle r=new Rectangle(xs[i]-4, ys[i]-4, 20,20);
            if(r.contains(e.getX(), e.getY()))
                drageIndex=i;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        drageIndex=-1;
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    
    public static void main(String[] args)
    {
        new BezierCurve();
    }
}
