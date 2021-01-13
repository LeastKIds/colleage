
//getsource , getText


package j210113.ch08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame{
    private JPanel panel;
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton addButton, subButton,mulButton,divButton,decButton,equButton,delButton,clrButton,negaButton;
    private String[] lables={"1","2","3","+",
                            "4","5","6","-",
                            "7","8","9","*",
                            ".","0","=","/"};
    private Font myFont=new Font(Font.SANS_SERIF, Font.BOLD, 30);
    private MyActionListtner listen=new MyActionListtner();
    public Calculator()
    {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,550);
        this.setLayout(null);

        textField=new JTextField();
        textField.setBounds(50,25,300,50);  //textField 위치
        textField.setFont(myFont);  //폰트 설정
        textField.setEditable(false);   //입력 불가

        panel=new JPanel();
        panel.setBounds(50,100,300,300); //panel 위치조정
        panel.setLayout(new GridLayout(4,4,10,10)); //panel 정렬

        numberButtons=new JButton[10];
        for(int i=0; i<numberButtons.length; i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        addButton=new JButton("+");
        addButton.setFocusable(false);
        addButton.setFont(myFont);
        addButton.addActionListener(listen);

        subButton=new JButton("-");
        subButton.setFocusable(false);
        subButton.setFont(myFont);
        mulButton=new JButton("*");
        mulButton.setFocusable(false);
        mulButton.setFont(myFont);
        divButton=new JButton("/");
        divButton.setFocusable(false);
        divButton.setFont(myFont);
        decButton=new JButton(".");
        decButton.setFocusable(false);
        decButton.setFont(myFont);
        equButton=new JButton("=");
        equButton.setFocusable(false);
        equButton.setFont(myFont);

        delButton=new JButton("Delete");
        delButton.setFocusable(false);
        delButton.setBounds(150,430,100,50);
        //delButton.setFont(myFont);

        clrButton=new JButton("Clear");
        clrButton.setFocusable(false);
        clrButton.setBounds(250,430,100,50);
        //clrButton.setFont(myFont);

        negaButton=new JButton("(-)");
        negaButton.setFocusable(false);
        negaButton.setBounds(50,430,100,50);
        //negaButton.setFont(myFont);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        this.add(negaButton);
        this.add(clrButton);
        this.add(delButton);
        this.add(panel);
        this.add(textField);
        this.setResizable(false);
        this.setLocationRelativeTo(null);   //frame 화면 중앙에 나타나도록 함.
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        JFrame calculator=new Calculator();
    }
}
