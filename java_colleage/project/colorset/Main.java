package project.colorset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
    private JPanel startPanel, mainPanel, menualPanel;

    public Main()
    {
        this.setSize(700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ColorSet");
        this.setResizable(false);
        this.setLayout(null);
        

        //  시작 페이지-------------------------------------------------------
        startPanel=new JPanel();
        startPanel.setLayout(null);
        startPanel.setBounds(0,0,700,700);
        startPanel.setBackground(Color.YELLOW);

        JLabel titleLabel=new JLabel("색깔 맞추기");
        titleLabel.setBounds(200,50,300,100);                       //  ------------> 제목 위치
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.blue);                       // ------------->   제목 배경
        titleLabel.setFont(new Font("Serif", Font.BOLD,30));        // ------------->   제목 글자 색, 크기 결정
        
        JButton startButton=new JButton("시작");
        startButton.setBounds(300,400,100,50);
        startButton.setBackground(Color.BLUE);
        startButton.setFont(new Font("고딕",Font.ITALIC,20));

        //  게임 설명 화면---------------------------------------------------
        menualPanel=new JPanel();
        menualPanel.setLayout(null);
        menualPanel.setBackground(new Color(255,255,255,200));
        menualPanel.setBounds(150,100,400,400);
        menualPanel.setVisible(false);
        JLabel explaineLabel=new JLabel("설명");
        explaineLabel.setBounds(50,50,300,100);
        explaineLabel.setOpaque(true);
        explaineLabel.setHorizontalAlignment(JLabel.CENTER);
        explaineLabel.setBackground(new Color(204,204,204));
        explaineLabel.setFont(new Font("Serif", Font.BOLD, 30));


        JLabel menualLabel=new JLabel();
        menualLabel.setText("크기가 중간인 글자의 뜻을 찾아 누르세요");
        menualLabel.setHorizontalAlignment(JLabel.CENTER);
        menualLabel.setBounds(50,150,300,100);
        menualLabel.setOpaque(true);
        menualLabel.setBackground(new Color(204,204,204));


        JButton menualButton=new JButton("닫기");
        menualButton.setBounds(150,300,100,50);
        JLabel menualButtonFrame=new JLabel();
        menualButtonFrame.setBounds(50,250,300,120);
        menualButtonFrame.setOpaque(true);
        menualButtonFrame.setBackground(new Color(204,204,204));


        menualPanel.add(menualLabel);
        menualPanel.add(explaineLabel);
        menualPanel.add(menualButton);
        menualPanel.add(menualButtonFrame);


        //  게임 화면--------------------------------------------------------
        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,700,700);
        mainPanel.setBackground(Color.WHITE);           //  -------------------------> 메인 페널 색
        mainPanel.add(menualPanel);
        mainPanel.setVisible(false);

                //  점수판
        JPanel pointPanel=new JPanel();
        pointPanel.setLayout(null);
        pointPanel.setBounds(0,0,700,100);
        pointPanel.setBackground(Color.GRAY);           //  --------------------------> 점수 패널 색
        JLabel pointTextLabel=new JLabel("점수");
        pointTextLabel.setBounds(0,0,700,50);
        pointTextLabel.setHorizontalAlignment(JLabel.CENTER);
        pointTextLabel.setFont(new Font("Serif", Font.BOLD,20));
        JLabel pointLabel=new JLabel();
        pointLabel.setBounds(0,50,700,50);
        pointLabel.setHorizontalAlignment(JLabel.CENTER);
        pointLabel.setFont(new Font("Serif", Font.BOLD, 15));
        pointLabel.setText("점수에요");                 // ----------------------------> 점수 여기다 추가


        pointPanel.add(pointTextLabel);
        pointPanel.add(pointLabel);
        pointPanel.setVisible(false);

                // 문제 판
        JPanel questionPanel=new JPanel();
        questionPanel.setLayout(null);
        questionPanel.setBounds(0,100,700,400);
        questionPanel.setBackground(Color.RED);
        JLabel questionTimer=new JLabel();
        questionTimer.setBounds(0,20,700,50);
        questionTimer.setHorizontalAlignment(JLabel.CENTER);
        questionTimer.setFont(new Font("Serif", Font.BOLD, 15));
        questionTimer.setText("째깍째깎");

        JPanel letterPanel1=new JPanel();
        letterPanel1.setBounds(30,100,180,200);
        letterPanel1.setBackground(Color.pink);
        JLabel letterLabel1=new JLabel("글자");
        letterLabel1.setFont(new Font("Serif", Font.BOLD,60));
        letterLabel1.setBounds(0,100,180,200);
        letterPanel1.add(letterLabel1);


        JPanel letterPanel2=new JPanel();
        letterPanel2.setBounds(250,100,180,200);
        letterPanel2.setBackground(Color.pink);
        JPanel letterPanel3=new JPanel();
        letterPanel3.setBounds(470,100,180,200);
        letterPanel3.setBackground(Color.pink);


        questionPanel.add(questionTimer);
        questionPanel.add(letterPanel1);
        questionPanel.add(letterPanel2);
        questionPanel.add(letterPanel3);

        questionPanel.setVisible(false);


        //  버튼
        JPanel answerPanel=new JPanel();
        answerPanel.setLayout(null);
        answerPanel.setBounds(0,500,700,200);
        answerPanel.setBackground(Color.GREEN);

        JButton button1=new JButton("빨강");
        button1.setBounds(100,50,100,50);
        JButton button2=new JButton("노랑");
        button2.setBounds(300,50,100,50);
        JButton button3=new JButton("파랑");
        button3.setBounds(500,50,100,50);
        answerPanel.add(button1);
        answerPanel.add(button2);
        answerPanel.add(button3);
        
        answerPanel.setVisible(false);
        

        //  패널에 추가 하고 숨기고 ------------------------------------------------------



        mainPanel.add(answerPanel);
        mainPanel.add(questionPanel);
        mainPanel.add(pointPanel);


        //  패널 추가---------------------------------------------------------
        startPanel.add(titleLabel);
        startPanel.add(startButton);
        this.add(startPanel);
        this.add(mainPanel);
        
        //  시작 버튼 누를 시 --------------------------------------------
        startButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                startPanel.setVisible(false);
                mainPanel.setVisible(true);
                menualPanel.setVisible(true);
                
				
			}
            
        });

        //  설명 닫기 버튼 누를 시 ----------------------------------------
        menualButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                menualPanel.setVisible(false);
                pointPanel.setVisible(true);
                questionPanel.setVisible(true);
                answerPanel.setVisible(true);

            }
            
        });

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        JFrame frame=new Main();
    }
}
