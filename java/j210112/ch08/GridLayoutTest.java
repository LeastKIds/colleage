package j210112.ch08;

import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame{

    public GridLayoutTest(){
        JButton button1=new JButton("Button1");
        JButton button2=new JButton("Button2");
        JButton button3=new JButton("Button3");
        JButton button4=new JButton("Long Named");
        JButton button5=new JButton("5");

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);

        // this.setLayout(new FlowLayout());
        // this.setSize(new Dimension(400,200));
        // this.setResizable(false);

        this.setLayout(new GridLayout(0,3));
        this.pack();
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        JFrame frame=new GridLayoutTest();
    }
}


