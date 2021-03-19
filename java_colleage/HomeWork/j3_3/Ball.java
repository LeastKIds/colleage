package HomeWork.j3_3;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball {
    private static final int RADIUS=20;
    int x=0;
    int y=0;
    int xSpeed=1;
    int ySpeed=1;
    private GameBoard game;
    private PointLabel point;
    Color color;
    int speed=1;
    int point1=0;
    int point2=0;

    public Ball(GameBoard game, Color color)
    {
        this.game=game;
        this.color=color;
    }

    void move()
    {
        //+speed 가 왜 붙는지 몰라서 다 뺐는데도 잘 돌아가는듯
        if(x<0)     
        {
            //xSpeed=(1+speed);
            reset();                // 양쪽 벽에 공이 닿으면 게임이 초기화
            point2++;               // 상대편에 점수 +1
            //System.out.println("point2 : " + point2);
        }
            
        if(x>=game.getWidth() - 2*RADIUS)
        {
            //xSpeed=-(1+speed);
            reset();                // 양쪽 벽에 공이 닿으면 게임이 초기화
            point1++;               // 상대편에 점수 +1;
            //System.out.println("point1 : " + point1);
        }
            
        if(y<0)
        {
            ySpeed=-(ySpeed);       // y가 반대로 움직이는 거라서 부호만 바꿔줌
            //System.out.println("y + ySpeed<0");
        }
           
        if(y>= game.getHeight() -2*RADIUS)
        {
            ySpeed=-(ySpeed);       // y가 반대로 움직이는 거라서 부호만 바꿔줌
            //System.out.println("y + ySpeed > game.getHeight() -2*RADIUS");
        }
            
        if(collision())
        {
            // 서로의 막대기에 공이 닿았을때 공의 속력을 높여줌
            if(xSpeed>=0)
                xSpeed-=speed;
            else
                xSpeed+=speed;
            
            if(ySpeed>=0)
                ySpeed+=speed/2;
            else
                ySpeed-=speed/2;
            
            
            speed++;        // 속력이 점점 증가
            
        }
        
        x = x+xSpeed;
        y = y+ySpeed;
    }

    private boolean collision()
    {
        return game.racquet1.getBounds().intersects(getBounds()) || game.racquet2.getBounds().intersects(getBounds());
    }

    public void draw(Graphics2D g)
    {
        g.setColor(color);
        g.fillOval(x,y,2*RADIUS, 2*RADIUS);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x,y,2*RADIUS, 2*RADIUS);
    }

    public void reset()
    {
        x=0;
        y=0;
        xSpeed=1;
        ySpeed=1;
        speed=1;
    }

    // 점수판에 쓰일 점수를 호출하는 메소드
    int getPoint1()
    {
        return point1;
    }
    int getPoint2()
    {
        return point2;
    }
}



