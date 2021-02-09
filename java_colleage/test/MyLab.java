package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyLab extends JFrame implements ActionListener{
    public static void main(String[] args)
    {
       MyLab frame=new MyLab();
    }

    JPanel panel1=new JPanel();
    JButton button1=new JButton("누름");
    JPanel panel2=new JPanel();
    JButton button2=new JButton("dldmd");

    public MyLab()
    {
        panel1.setBackground(Color.BLACK);
        panel2.setBackground(Color.GREEN);

        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        button1.addActionListener(this);
        panel1.add(button1);
        panel2.add(button2);
        button2.addActionListener(this);
        this.add(panel1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==button1)
        {
            this.remove(panel1);
            this.add(panel2);

            revalidate();
            repaint();
        }
        if(e.getSource()==button2)
        {
            this.removeAll();
            revalidate();
            repaint();
        }
    }
}
