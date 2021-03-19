package HomeWork.j3_3;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoard extends JPanel implements KeyListener{
    Ball ball;
    Racquet racquet1;
    Racquet racquet2;
    static PointLabel point;        // 점수 판

    public GameBoard()
    {
        ball=new Ball(this,Color.red);
        this.setBackground(Color.green);
        racquet1=new Racquet(this,10,150,Color.blue,1);
        racquet2=new Racquet(this, 560, 150, Color.yellow,2);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        racquet1.keyPressed(e);
        racquet2.keyPressed(e);
        //System.out.println("keyPressed");
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        racquet1.keyReleased(e);
        racquet2.keyReleased(e);
        //System.out.println("keyReleased");
    }

    private void move()
    {
        ball.move();
        racquet1.move();
        racquet2.move();
        point.setPoint(ball.getPoint1(),ball.getPoint2());  // 점수 라벨에 점수 대입
        point.setPointPanel();  // 위에 점수로 점수표 바꾸기
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d= (Graphics2D) g;
        ball.draw(g2d);
        racquet1.draw(g2d);
        racquet2.draw(g2d);

    }

    public static void main(String[] args)
    {
        JFrame frame=new JFrame("Pong Game");
        frame.setSize(600,400);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GameBoard game=new GameBoard();
        point=new PointLabel();
        game.add(point, BorderLayout.NORTH);    // 점수판 추가
        frame.add(game);

        // frame.revalidate();
        // frame.repaint();
        frame.setVisible(true);
        while(true)
        {
            game.move();
            game.revalidate();
            game.repaint();
            try{
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
    }
}


