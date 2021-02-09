package project.colorset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

 public class Main extends JFrame implements ActionListener{
    private JPanel startPanel, mainPanel, menualPanel;
    JButton startButton, menualButton;
    JButton button1,button2,button3;
    JLabel letterLabel1, letterLabel2, letterLabel3, pointLabel,questionTimer;
    Container contentPane=getContentPane();

    Execution1 ex=new Execution1();
    Panel rt=new Panel();


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
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.blue);                       // ------------->   제목 배경
        titleLabel.setFont(new Font("고딕", Font.BOLD,30));        // ------------->   제목 글자 색, 크기 결정
        
        startButton=new JButton("시작");
        startButton.setBounds(300,400,100,50);
        startButton.setBackground(Color.BLUE);
        startButton.setFont(new Font("고딕",Font.ITALIC,20));
        startButton.setFocusable(false);

        //  게임 설명 화면---------------------------------------------------
        menualPanel=new JPanel();
        menualPanel.setLayout(null);
        menualPanel.setBackground(new Color(255,255,255,200));
        menualPanel.setBounds(0,0,700,700);
        //menualPanel.setVisible(false);
        JLabel explaineLabel=new JLabel("설명");
        explaineLabel.setBounds(190,150,300,100);
        explaineLabel.setOpaque(true);
        explaineLabel.setHorizontalAlignment(SwingConstants.CENTER);
        explaineLabel.setBackground(new Color(204,204,204));
        explaineLabel.setFont(new Font("고딕", Font.BOLD, 30));


        JLabel menualLabel=new JLabel();
        menualLabel.setText("크기가 중간인 글자의 색을 찾아 누르세요");
        menualLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menualLabel.setBounds(190,250,300,100);
        menualLabel.setOpaque(true);
        menualLabel.setBackground(new Color(204,204,204));


        menualButton=new JButton("닫기");
        menualButton.setBounds(290,380,100,50);
        menualButton.setFocusable(false);
        JLabel menualButtonFrame=new JLabel();
        menualButtonFrame.setBounds(190,350,300,120);
        menualButtonFrame.setOpaque(true);
        menualButtonFrame.setBackground(new Color(204,204,204));


        menualPanel.add(menualLabel);
        menualPanel.add(explaineLabel);
        menualPanel.add(menualButton);
        menualPanel.add(menualButtonFrame);


        //  게임 화면--------------------------------------------------------
        mainPanel=new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,700,700);
        mainPanel.setBackground(Color.WHITE);           //  -------------------------> 메인 페널 색
        mainPanel.add(menualPanel);
        //mainPanel.setVisible(false);

                //  점수판
        JPanel pointPanel=new JPanel();
        pointPanel.setLayout(null);
        pointPanel.setBounds(0,0,700,100);
        pointPanel.setBackground(Color.GRAY);           //  --------------------------> 점수 패널 색
        JLabel pointTextLabel=new JLabel("점수");
        // pointTextLabel.setBounds(0,0,700,50);
        // pointTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // pointTextLabel.setFont(new Font("고딕", Font.BOLD,20));
        pointLabel=new JLabel();
        pointLabel.setBounds(0,25,700,50);
        pointLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pointLabel.setFont(new Font("고딕", Font.BOLD, 30));
        pointLabel.setText("0");                 // ----------------------------> 점수 여기다 추가


        pointPanel.add(pointTextLabel);
        pointPanel.add(pointLabel);
        //pointPanel.setVisible(false);

                // 문제 판
        JPanel questionPanel=new JPanel();
        questionPanel.setLayout(null);
        questionPanel.setBounds(0,100,700,400);
        questionPanel.setBackground(Color.RED);
        questionTimer=new JLabel();
        questionTimer.setBounds(0,20,700,50);
        questionTimer.setHorizontalAlignment(JLabel.CENTER);
        questionTimer.setFont(new Font("고딕", Font.BOLD, 20));
        questionTimer.setText("째깍째깎");

        JPanel letterPanel1=new JPanel();
        letterPanel1.setLayout(new BorderLayout());
        letterPanel1.setBounds(30,100,180,200);
        letterPanel1.setBackground(Color.pink);

        letterLabel1=new JLabel("글자");
        letterLabel1.setFont(new Font("고딕", Font.BOLD,60));
        letterLabel1.setHorizontalAlignment(JLabel.CENTER);
        //letterLabel1.setBounds(0,30,180,200);
        //letterLabel1.setOpaque(true);
        //letterLabel1.setBackground(Color.BLACK);
        letterPanel1.add(letterLabel1);


        JPanel letterPanel2=new JPanel();
        letterPanel2.setBounds(250,100,180,200);
        letterPanel2.setBackground(Color.pink);
        letterPanel2.setLayout(new BorderLayout());

        letterLabel2=new JLabel("글자");
        // letterLabel2.setFont(new Font("고딕", Font.BOLD,60));
        letterLabel2.setHorizontalAlignment(JLabel.CENTER);
        letterPanel2.add(letterLabel2);

        JPanel letterPanel3=new JPanel();
        letterPanel3.setBounds(470,100,180,200);
        letterPanel3.setBackground(Color.pink);
        letterPanel3.setLayout(new BorderLayout());

        letterLabel3=new JLabel("글자");
        // letterLabel3.setFont(new Font("고딕", Font.BOLD,60));
        letterLabel3.setHorizontalAlignment(JLabel.CENTER);
        letterPanel3.add(letterLabel3);


        questionPanel.add(questionTimer);
        questionPanel.add(letterPanel1);
        questionPanel.add(letterPanel2);
        questionPanel.add(letterPanel3);

        //questionPanel.setVisible(false);


        //  버튼
        JPanel answerPanel=new JPanel();
        answerPanel.setLayout(null);
        answerPanel.setBounds(0,500,700,200);
        answerPanel.setBackground(Color.GREEN);

        button1=new JButton("빨강");
        button1.setBounds(100,50,100,50);
        button1.setFocusable(false);
        button1.setEnabled(false);
        button2=new JButton("노랑");
        button2.setBounds(300,50,100,50);
        button2.setFocusable(false);
        button2.setEnabled(false);
        button3=new JButton("파랑");
        button3.setBounds(500,50,100,50);
        button3.setFocusable(false);
        button3.setEnabled(false);
        answerPanel.add(button1);
        answerPanel.add(button2);
        answerPanel.add(button3);
        
        //answerPanel.setVisible(false);
        

        //  패널에 추가 하고 숨기고 ------------------------------------------------------



        mainPanel.add(answerPanel);
        mainPanel.add(questionPanel);
        mainPanel.add(pointPanel);


        //  패널 추가---------------------------------------------------------
        startPanel.add(titleLabel);
        startPanel.add(startButton);
        this.add(startPanel);
        //this.add(mainPanel);
        this.add(rt.retryPanel);
        
        //  시작 버튼 누를 시 --------------------------------------------
        startButton.addActionListener(this);

		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
        //         // TODO Auto-generated method stub
        //         //startPanel.setVisible(false);
        //         Main.this.remove(startPanel);
        //         mainPanel.setVisible(true);
        //         menualPanel.setVisible(true);
                
				
		// 	}
            
        // });

        //  설명 닫기 버튼 누를 시 ----------------------------------------
        menualButton.addActionListener(this);

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         // TODO Auto-generated method stub
        //         menualPanel.setVisible(false);
        //         pointPanel.setVisible(true);
        //         questionPanel.setVisible(true);
        //         answerPanel.setVisible(true);

        //        ex.repeat(letterLabel1, letterLabel2, letterLabel3,button1,button2,button3);
        //        ex.setPoint(pointLabel);
        //        ex.setQuestionTimer(questionTimer);
        //        ex.setPanel(mainPanel,menualPanel,rt.retryPanel,rt.lastPoint);
        //     }
            
        // });

        rt.retryButton.addActionListener(this);
        // {

		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		// TODO Auto-generated method stub
        //         rt.retryPanel.setVisible(false);
		// 		mainPanel.setVisible(true);
               
        //         ex.regame();
        //         ex.repeat(letterLabel1, letterLabel2, letterLabel3,button1,button2,button3);
        //        ex.setPoint(pointLabel);
        //        ex.setQuestionTimer(questionTimer);
        //        ex.setPanel(mainPanel,menualPanel,rt.retryPanel,rt.lastPoint);
               
		// 	}
            
        // });

        this.setVisible(true);


    }

    
    

    public static void main(String[] args)
    {
        JFrame frame=new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==startButton)
        {
            contentPane.remove(startPanel);
            contentPane.add(mainPanel);

            contentPane.revalidate();
            contentPane.repaint();
        }
        else if(e.getSource()==menualButton)
        {
            menualPanel.setVisible(false);
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            contentPane.revalidate();
            contentPane.repaint();

            ex.repeat(letterLabel1, letterLabel2, letterLabel3,button1,button2,button3);
            ex.setPoint(pointLabel);
            ex.setQuestionTimer(questionTimer);
            ex.setPanel(mainPanel,menualPanel,rt.retryPanel,rt.lastPoint);
            ex.setContentPane(contentPane);
            
        }
        else if(e.getSource()==rt.retryButton)
        {
            System.out.println("dd");
            rt.retryPanel.setVisible(false);
            contentPane.revalidate();
            contentPane.repaint();
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            ex.resetGame();

        }

    }
}
