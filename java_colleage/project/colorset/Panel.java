package project.colorset;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Panel extends JPanel{
    Execution1 ex=new Execution1();
    JPanel retryPanel=new JPanel();
    JButton retryButton, exitButton;
    JLabel lastPoint=new JLabel();

    public Panel()
    {
        retryPanel.setLayout(null);
        retryPanel.setBackground(new Color(255,255,255,200));
        retryPanel.setBounds(0,0,700,700);
        retryPanel.setVisible(false);


        JLabel timeOutLabel =new JLabel("시간 초과!!");
        timeOutLabel.setBounds(200,50,300,100);
        timeOutLabel.setHorizontalAlignment(JLabel.CENTER);
        timeOutLabel.setFont(new Font("고딕",Font.BOLD,20));
        retryPanel.add(timeOutLabel);

        lastPoint.setBounds(200,130,300,100);   
        retryPanel.add(lastPoint);

        JLabel tryLabel=new JLabel("다시 시작하겠습니까?");
        tryLabel.setBounds(200,200,300,100);
        tryLabel.setHorizontalAlignment(JLabel.CENTER);
        tryLabel.setFont(new Font("고딕",Font.BOLD,25));
        retryPanel.add(tryLabel);

        retryButton=new JButton("다시하기");
        retryButton.setBounds(150,300,100,50);
        retryPanel.add(retryButton);

        exitButton=new JButton("끝내기");

        // System.out.println("ex " + ex.getPoint());

        

        


        
    }

    public void setLastPoint(String point)
    {
        lastPoint.setText(point);
    }
}
