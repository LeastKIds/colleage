package j210112.ch08;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest extends JFrame {
    public FlowLayoutTest()
    {
        JButton button1=new JButton("Button1");
        JButton button2=new JButton("Button2");
        JButton button3=new JButton("Button3");
        JButton button4=new JButton("Long Named");
        JButton button5=new JButton("5");

        this.add(button1, BorderLayout.NORTH);  // public static final String NORTH="North";
        this.add(button2, BorderLayout.CENTER);
        this.add(button3, BorderLayout.WEST);
        this.add(button4, BorderLayout.SOUTH);
        this.add(button5, BorderLayout.EAST);

        // this.setLayout(new FlowLayout());
        // this.setSize(new Dimension(400,200));
        // this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        JFrame frame=new FlowLayoutTest();
    }
}
