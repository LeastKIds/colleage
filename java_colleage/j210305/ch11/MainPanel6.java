package j210305.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    Double getA(){A=Double.parseDouble(a.getText()); return A;}
    Double getB(){B=Double.parseDouble(b.getText()); return B;}
    Double getC(){C=Double.parseDouble(c.getText()); return C;}
}

public class MainPanel6 extends JFrame implements ActionListener
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
    MyPanel4 myPanel4=new MyPanel4();
    DrawPanel drawPanel=new DrawPanel();
    
    public MainPanel6()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(myPanel4);
        this.add(drawPanel);
        myPanel4.button.addActionListener(this);
        this.setSize(500,400);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainPanel6();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        drawPanel.setABC(myPanel4.getA(),myPanel4.getB(),myPanel4.getC());
        drawPanel.setRepaint();
    }
    
    
}

class DrawPanel extends JPanel
    {
        Double A=0.0 ,B=0.0 ,C=0.0 ;
        JPanel test=new JPanel();
        void setRepaint()
        {
            repaint();
        }
        public DrawPanel()
        {
            this.setBounds(0,100,500,300);
        }
        void setABC(Double A, Double B, Double C)
        {
            this.A=A;
            this.B=B;
            this.C=C;
        }
        @Override
        public void paintComponent(Graphics g) {
            // TODO Auto-generated method stub
            super.paintComponent(g);
            Graphics2D g2=(Graphics2D) g;
            g2.drawLine(0,200,400,200);
            g2.drawLine(200,0,200,400);
            g2.setPaint(Color.red);
            for(int i=-20; i<20; i++)
            {
                int x=i;
                int y= (int)(A * x * x + B*x + C);
                g2.fillOval(200+x-2, 200-(y-2), 4,4);
            }
        }
    }

