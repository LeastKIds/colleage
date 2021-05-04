package j210305.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 그래프 위치 조정은 안 함
//----------------------------------------------------------------------------------

// 맨 위에 텍스트필드랑 버튼 들어가는 패널이 들어 있는 클래스
class MyPanel4 extends JPanel{

    JTextField a,b,c;
    double A,B,C;
    JButton button;

    public MyPanel4()
    {
        this.setBounds(0,0,500,100);
        a=new JTextField("1.0",10);
        b=new JTextField("-5.0",10);
        c=new JTextField("6.0",10);
        add(a);
        add(b);
        add(c);
        button=new JButton("DRAW");
        add(button);
    } 
    Double getA(){A=Double.parseDouble(a.getText()); return A;} // 6. 이 클래스 밖으로 A,B,C 값을 빼내기 위해
    Double getB(){B=Double.parseDouble(b.getText()); return B;} // 각 각의 값을 return 해 주는 메소드들을 만듬
    Double getC(){C=Double.parseDouble(c.getText()); return C;} // a.getText()는 a 안에 들어있는 값을 가져오는 것
                                                                // Double.parseDouble은 그 값을 Double형으로 변환
}

// 프레임이 들어 있는 클래스 
public class MainPanel6 extends JFrame implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
    MyPanel4 myPanel4=new MyPanel4();       // 1. 프레임에서 텍스트 필드 패널 생성
    DrawPanel drawPanel=new DrawPanel();    // 2. 프레임에서 그래프 패널 생성
    
    public MainPanel6()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(myPanel4);
        this.add(drawPanel);
        myPanel4.button.addActionListener(this);    // 3. 텍스트 필드 패널에 있는 draw 패널 버튼을 누를 시 actionListener가 실행
        this.setSize(500,400);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainPanel6();
    }

    @Override
    public void actionPerformed(ActionEvent e) {    // 4. 버튼 누를시 실행되는 명령어
        // TODO Auto-generated method stub
        drawPanel.setABC(myPanel4.getA(),myPanel4.getB(),myPanel4.getC());  // 5. 그래프 패널에 A, B, C 값을 넣어주는 메소드
        drawPanel.setRepaint();     // 8. 그래프를 그리는 패널에서 다시그려주는(repaint)를 실행시켜주는 메소드
    }
    
    
}

// 그래프를 그리는 패널이 들어있는 클래스
class DrawPanel extends JPanel
    {
        Double A=0.0 ,B=0.0 ,C=0.0 ;
        JPanel test=new JPanel();
        void setRepaint()   // 9. 다시 그려주는 repaint 메소드
        {
            repaint();
        }
        public DrawPanel()
        {
            this.setBounds(0,100,500,300);
        }
        void setABC(Double A, Double B, Double C)   // 7. 텍스트 필드 패널 클래스에 있는 A,B,C가 다른 클래스이므로
        {                                           // 접근이 불가해서 텍스트 필드 클래스에 있는 값을 받아서
            this.A=A;                               // 이곳에서 넣어주게 됨
            this.B=B;
            this.C=C;
        }
        @Override
        public void paintComponent(Graphics g) {    // 10. repaint()로 실행 되는 메소드
            // TODO Auto-generated method stub
            super.paintComponent(g);
            Graphics2D g2=(Graphics2D) g;
            g2.drawLine(0,200,400,200);
            g2.drawLine(200,0,200,400);
            g2.setPaint(Color.red);
            for(int i=-200; i<200; i++)
            {
                int x=i;
                int y= (int)(A * x * x + B*x + C);
                g2.fillOval(200+x-2, 200-(y-2), 4,4);
            }
        }
    }

