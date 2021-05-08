package j210129.ch10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BackgroundChange extends JFrame  implements ActionListener{
    private JButton button1;
    private JButton button2;
    private JPanel panel;

    public BackgroundChange()
    {
        this.setSize(300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("이벤트 예제");

        button1=new JButton("노란색");
        button1.addActionListener(this);
        button2=new JButton("핑크색");
        button2.addActionListener(this);
        panel=new JPanel();

        panel.add(button1);
        panel.add(button2);

        this.add(panel, BorderLayout.NORTH);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
 

    }

    public static void main(String[] args)
    {
        JFrame frame=new BackgroundChange();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1)
        {
            this.setBackground(Color.YELLOW);
            this.getContentPane().setBackground(Color.YELLOW);

        }
        else if(e.getSource()==button2)
        {
            panel.setBackground(Color.PINK);
        }

    }
}
