package j210203.ch10;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CounterTest extends JFrame {

    private int number=0;
    public CounterTest()
    {
        this.setSize(300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);

        JLabel label=new JLabel();
        
        label.setText("0");
        label.setBounds(120,40,70,100);
        label.setFont(new Font("고딕", Font.PLAIN,60));

        JButton upButton=new JButton("UP");
        upButton.setFont(new Font("고딕",Font.PLAIN,20));
        upButton.setBounds(30,30,100,25);
        upButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                number+=1;
                label.setText(Integer.toString(number));
			}
            
        });
        JButton downButton=new JButton("DOWN");
        downButton.setFont(new Font("고딕",Font.PLAIN,20));
        downButton.setBounds(150,30,100,25);
        downButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                number -=1;
                label.setText(Integer.toString(number));
			}
            
        });

        this.add(label);
        this.add(upButton);
        this.add(downButton);

    }

    public static void main(String[] args)
    {
        JFrame frame=new CounterTest();
    }
}
