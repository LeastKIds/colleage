package project.colorset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class Execution1 extends JFrame implements ActionListener, Runnable{

    Random rand=new Random();
    private int time=6;
    private int second=0;
    private String answer;
    private String colorAnswer;
    private int answerCheck;
    private int count=0;
    private int point=0;
    JButton[] actionButton=new JButton[3];
    JLabel[] actionLetter=new JLabel[3];
    JLabel pointCheck=new JLabel();
    JLabel timeCheck=new JLabel();
    JPanel subMainPanel, subMenualPanel, subRetryPanel;
    JLabel subLastPoint;
    Container mainContentPane;
    Timer timer;
    TimerTask timerTask;


    public void randomLetterSetting(JLabel letterLabel1, JLabel letterLabel2, JLabel letterLabel3)
    {

        // JLabel[] letterLabel=new JLabel[3];
        // letterLabel[0]=letterLabel1;
        // letterLabel[1]=letterLabel2;
        // letterLabel[2]=letterLabel3;
        ArrayList<String> randomLetter=new ArrayList<>();
        randomLetter.add("빨강");
        randomLetter.add("노랑");
        randomLetter.add("파랑");

        ArrayList<Integer> randomColor=new ArrayList<>();
        randomColor.add(0); //  0이면 빨강
        randomColor.add(1); //  1이면 노랑
        randomColor.add(2); //  2이면 파랑

        ArrayList<Integer> randomSize=new ArrayList<>();
        randomSize.add(20);
        randomSize.add(40);
        randomSize.add(60);

        int randomInt;
        for(int i=0; i<3; i++)
        {
            randomInt=rand.nextInt(3-i);
            actionLetter[i].setText(randomLetter.get(randomInt));
            randomLetter.remove(randomInt);

            randomInt=rand.nextInt(3-i);
            switch(randomColor.get(randomInt))
            {
                case 0 :
                actionLetter[i].setForeground(Color.RED);
                    colorAnswer="빨강";
                    break;
                case 1 :
                actionLetter[i].setForeground(Color.YELLOW);
                    colorAnswer="노랑";
                    break;
                case 2 :
                actionLetter[i].setForeground(Color.BLUE);
                    colorAnswer="파랑";
                    break;
                default :
                    break;
            }
            randomColor.remove(randomInt);

            randomInt=rand.nextInt(3-i);
            switch(randomSize.get(randomInt))
            {
                case 20 :
                actionLetter[i].setFont(new Font("고딕", Font.BOLD,20));
                    break;
                case 40 :
                actionLetter[i].setFont(new Font("고딕", Font.BOLD,40));
                    answer=colorAnswer;
                    break;
                case 60 :
                actionLetter[i].setFont(new Font("고딕", Font.BOLD,60));
                     break;
                default :
                    break;
            }
            randomSize.remove(randomInt);

            //letterLabel1=actionLetter[i];
        }
        
    }

    
    public void repeat(JLabel letterLabel1, JLabel letterLabel2, JLabel letterLabel3, JButton button1, JButton button2, JButton button3)
    {
        JButton[] button=new JButton[3];
        button[0]=button1;
        button[1]=button2;
        button[2]=button3;
    
        actionButton[0]=button1;
        actionButton[1]=button2;
        actionButton[2]=button3;

        actionLetter[0]=letterLabel1;
        actionLetter[1]=letterLabel2;
        actionLetter[2]=letterLabel3;

        int checkLetter=0;
        int checkTimer=0;

        randomLetterSetting(actionLetter[0], actionLetter[1], actionLetter[2]);

        //MyListener myListener=new MyListener(button1,button2,button3,answer);
            
        actionButton[0].addActionListener(this);
        actionButton[1].addActionListener(this);
        actionButton[2].addActionListener(this);

        

        secondTimer();
     
    }

    public void secondTimer()
    {
        second=0;
        timer=new Timer();
        timerTask=new TimerTask()
        {

			@Override
			public void run() {
            // TODO Auto-generated method stub
                
                
                second++;
                System.out.println(answer);
                timeCheck.setText(Integer.toString(time-second));
                System.out.println(second);
                if(second>=time)
                {
                    System.out.println("시간초과");
                    timeCheck.setText("시간 초과!!");
                    
                    // subMainPanel.setVisible(false);
                    retryGame();
                    

                    timer.cancel();
                }

              
            }

        
        };
        timer.schedule(timerTask,0,1000);


    }

    public void retryGame()
    {
        subLastPoint.setText(Integer.toString(point));
        subRetryPanel.setVisible(true);
    }


   


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==actionButton[0] && actionButton[0].getText().equals(answer))
        {
                System.out.println("정답1");
                timer.cancel();
                secondTimer();
                count++;
                point++;
                pointCheck.setText(Integer.toString(point));
                if(count==3)
                {
                    count=0;
                    if(time>2)
                        time-=1;
                    
                }
                randomLetterSetting(actionLetter[0], actionLetter[1], actionLetter[2]);
            
        }
        else if(e.getSource()==actionButton[1] && actionButton[1].getText().equals(answer))
        {
            
                System.out.println("정답2");
                timer.cancel();
                secondTimer();
                count++;
                point++;
                pointCheck.setText(Integer.toString(point));
                if(count==3)
                {
                    count=0;
                    if(time>2)
                        time-=1;
                }
                randomLetterSetting(actionLetter[0], actionLetter[1], actionLetter[2]);
        }
        else if(e.getSource()==actionButton[2] && actionButton[2].getText().equals(answer))
        {
                System.out.println("정답3");
                timer.cancel();
                secondTimer();
                count++;
                point++;
                pointCheck.setText(Integer.toString(point));
                if(count==3)
                {
                    count=0;
                    if(time>2)
                        time-=1;
                }
                randomLetterSetting(actionLetter[0], actionLetter[1], actionLetter[2]);
            
        }
        else
        {
            System.out.println("삐삐끼삒삒삐끼ㅃ끼ㅃㄲ");
            actionButton[0].setEnabled(false);
            actionButton[1].setEnabled(false);
            actionButton[2].setEnabled(false);
            retryGame();
            timer.cancel();
            
        }


    }

    public void setPanel(JPanel mainPanel, JPanel menualPanel, JPanel retryPanel, JLabel lastPoint)
    {
        subMainPanel=mainPanel;
        subMenualPanel=menualPanel;
        subRetryPanel=retryPanel;
        subLastPoint=lastPoint;
    }

    public void setContentPane(Container contentPane)
    {
        mainContentPane=contentPane;
    }

    public void setPoint(JLabel pointLabel)
    {
        pointCheck=pointLabel;
    }

    public void setQuestionTimer(JLabel questionTimer)
    {
        timeCheck=questionTimer;
    }

    public void resetGame()
    {
        time=6;
        second=0;
        point=0;
        pointCheck.setText("0");
        randomLetterSetting(actionLetter[0], actionLetter[1], actionLetter[2]);
        secondTimer();
    }


}
    

// class MyListener extends JButton implements ActionListener
// {

//     JButton[] button=new JButton[3];
//     String answer;
//     int answerCheck;
//     public MyListener(JButton button1,JButton button2,JButton button3,String answer)
//     {
//         button[0]=button1;
//         button[1]=button2;
//         button[2]=button3;
//         this.answer=answer;
//     }
//     @Override
//     public void actionPerformed(ActionEvent e) {
//         // TODO Auto-generated method stub
//         if(e.getSource()==button[0])
//         {
//             System.out.println(button[0].getText());
//             if(button[0].getText().equals(answer))
//             {
//                 System.out.println("정답1");
                
//             }
//         }
//         else if(e.getSource()==button[1])
//         {
//             System.out.println(button[1].getText());
//             if(button[1].getText().equals(answer))
//             {
//                 System.out.println("정답2");
//             }
//         }
//         else if(e.getSource()==button[2])
//         {
//             System.out.println(button[2].getText());
//             if(button[2].getText().equals(answer))
//             {
//                 System.out.println("정답3");
//             }
//         }
//     }
    
// }



