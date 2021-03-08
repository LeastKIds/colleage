package j210308.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class RadioButtonFrame extends JFrame implements ActionListener{

    private JRadioButton small, medium, large;
    private JLabel text;
    private JPanel topPanel, sizePanel, resultPanel;

    public RadioButtonFrame()
    {
        this.setTitle("Radio Button Test");
        this.setSize(300,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        topPanel=new JPanel();
        JLabel label=new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
        topPanel.add(label);
        this.add(topPanel,BorderLayout.NORTH);

        sizePanel=new JPanel();
        small=new JRadioButton("Small Size");
        medium=new JRadioButton("Medium Size");
        large=new JRadioButton("Large Size");

        ButtonGroup size=new ButtonGroup();
        size.add(small);
        size.add(medium);
        size.add(large);

        small.addActionListener(this);
        medium.addActionListener(this);
        large.addActionListener(this);

        sizePanel.add(small);
        sizePanel.add(medium);
        sizePanel.add(large);

        Border border=BorderFactory.createTitledBorder("크기");
        sizePanel.setBorder(border);

        this.add(sizePanel, BorderLayout.CENTER);

        resultPanel=new JPanel();
        text=new JLabel("크기가 선택되지 않았습니다.");
        text.setForeground(Color.red);
        resultPanel.add(text);
        this.add(resultPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == small)
            text.setText("small 크기가 선택되었습니다.");
        else if(e.getSource()==medium)
            text.setText("medium 크기가 선택되었습니다.");
        else if(e.getSource()==large)
            text.setText("large 크기가 선택되었습니다.");
        
    }

    public static void main(String[] args)
    {
        new RadioButtonFrame();
    }
    
}
