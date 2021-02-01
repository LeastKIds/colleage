package j210128.ch10;

import javax.swing.*;
import java.awt.event.*;

public class MyFrame1 extends JFrame implements ActionListener{
    private JButton button;
    private JLabel label;

    public MyFrame1()
    {
        this.setSize(300,200);  //frame 폭과 높이 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //  close x 누르면 꺼짐
        this.setTitle("이벤트 예제");

        JPanel panel=new JPanel();

        button=new JButton("버튼을 누르시오");
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                button.setText("눌려졌습니다.");
                label.setText("라벨도 눌려졌습니다.");

            }
            
        });
        label=new JLabel("아직 버튼이 눌려지지 않았습니다.");
        

        panel.add(button);  //따로 레이아웃 설정하지 않으면 flow 레이아웃
        panel.add(label);

        this.add(panel);    //패널 레이아웃을 설정하지 않으면 border 레이아웃

        this.setVisible(true);

    }
}
