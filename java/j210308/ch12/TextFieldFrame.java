package j210308.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFieldFrame extends JFrame{
    private JButton button;
    private JTextField text, result;

    public TextFieldFrame()
    {
        this.setSize(300,130);
        this.setTitle("제곱 계산하기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonListener listener=new ButtonListener();

        JPanel panel=new JPanel();
        panel.add(new JLabel("숫자 입력 : "));
        text=new JTextField(15);
        text.addActionListener(listener);
        panel.add(text);

        panel.add(new JLabel("제곱한 값 : " ));
        result=new JTextField(15);
        result.setEditable(false);
        panel.add(result);

        button=new JButton("OK");
        button.addActionListener(listener);
        panel.add(button);
        
        this.add(panel);
        this.setVisible(true);
    }

    private class ButtonListener implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(e.getSource()==button || e.getSource()== text)
            {
                String name=text.getText();
                int value=Integer.parseInt(name);
                result.setText("" + value * value);
                text.requestFocus();
            }
        }
    
    }

    public static void main(String[] args)
    {
        new TextFieldFrame();
    }
}


