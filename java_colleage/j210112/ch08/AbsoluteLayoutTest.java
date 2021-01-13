package j210112.ch08;

import javax.swing.*;
import java.awt.*;

public class AbsoluteLayoutTest extends JFrame{
    public AbsoluteLayoutTest()
    {
        this.setTitle("Absolute Position Test");
        this.setSize(400,200);

        JButton b1=new JButton("Button #1");
        JButton b2=new JButton("Button #2");
        JButton b3=new JButton("Button #3");

        b1.setBounds(150, 50, 100, 100);
        b2.setBounds(0, 100, 100, 100);
        b3.setBounds(300, 100, 100, 100);

        this.add(b1);
        this.add(b2);
        this.add(b3);
        
        this.setLayout(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        JFrame frame=new AbsoluteLayoutTest();
    }
}
