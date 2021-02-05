package project.colorset;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Panel extends JPanel{
    JPanel retryPanel=new JPanel();
    public Panel()
    {
        retryPanel.setLayout(null);
        retryPanel.setBackground(new Color(255,255,255,200));
        retryPanel.setBounds(150,100,400,400);
        //retryPanel.setVisible(false);
        JLabel tryLabel=new JLabel("다시 시작하겠습니까?");
        tryLabel.setBounds(50,50,300,100);
        tryLabel.setHorizontalAlignment(JLabel.CENTER);
        tryLabel.setFont(new Font("고딕",Font.BOLD,30));

        JButton retryButton=new JButton("다시하기");
        retryButton.setBounds(150,300,100,50);

        


        // menualPanel.setLayout(null);
        // menualPanel.setBackground(new Color(255,255,255,200));
        // menualPanel.setBounds(150,100,400,400);
        // menualPanel.setVisible(false);
        // JLabel explaineLabel=new JLabel("설명");
        // explaineLabel.setBounds(50,50,300,100);
        // explaineLabel.setOpaque(true);
        // explaineLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // explaineLabel.setBackground(new Color(204,204,204));
        // explaineLabel.setFont(new Font("고딕", Font.BOLD, 30));


        // JLabel menualLabel=new JLabel();
        // menualLabel.setText("크기가 중간인 글자의 색을 찾아 누르세요");
        // menualLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // menualLabel.setBounds(50,150,300,100);
        // menualLabel.setOpaque(true);
        // menualLabel.setBackground(new Color(204,204,204));


        // JButton menualButton=new JButton("닫기");
        // menualButton.setBounds(150,300,100,50);
        // menualButton.setFocusable(false);
        // JLabel menualButtonFrame=new JLabel();
        // menualButtonFrame.setBounds(50,250,300,120);
        // menualButtonFrame.setOpaque(true);
        // menualButtonFrame.setBackground(new Color(204,204,204));
    }
}
