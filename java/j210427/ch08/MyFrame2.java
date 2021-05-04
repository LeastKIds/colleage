package j210427.ch08;

import javax.swing.*;
import java.awt.*;

public class MyFrame2 extends JFrame{
    JPanel p1;

    public MyFrame2()
    {
        this.setSize(300,200);
        this.setTitle("MyFrame");

        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        for(int i=0; i<10; i++)
            p1.add(new JButton("button" + i));

        this.add(p1);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
