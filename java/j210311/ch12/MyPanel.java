package j210311.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener{
    JTextField A,B,C;
    Double a=0.0,b=0.0,c=0.0;

    public MyPanel()
    {
        A=new JTextField("1.0",10);
        B=new JTextField("-5.0",10);
        C=new JTextField("6.0",10);

        this.add(A);
        this.add(B);
        this.add(C);

        JButton button=new JButton("DRAW");
        button.addActionListener(this);
        this.add(button);


    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D) g;
        g2.drawLine(0,200,400,200);
        g2.drawLine(200,0,200,400);
        g2.setPaint(Color.red);
        for(int i= -200; i<=200; i++)
        {
            int x=i;
            int y=(int) (a*x*x + b*x + c);
            g2.fillOval(200+x+2,200-(y-2),4,4);

        }
    }

    public static void main(String[] args)
    {
        JFrame f=new JFrame();
        f.setSize(500,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.add(new MyPanel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        a=Double.parseDouble(A.getText());
        b=Double.parseDouble(B.getText());
        c=Double.parseDouble(C.getText());
        repaint();
    }
}
