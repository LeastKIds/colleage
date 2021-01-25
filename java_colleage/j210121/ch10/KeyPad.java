package j210121.ch10;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.*;

class MyFrame extends JFrame
{
    private JTextField txt;
    private JPanel panel;

    public MyFrame()
    {
        txt=new JTextField(20);
        add(txt, BorderLayout.NORTH);
        panel=new JPanel();
        panel.setLayout(new GridLayout(3,3));
        add(panel,BorderLayout.CENTER);
        for(int i=1; i<=9; i++)
        {
            JButton btn=new JButton("" + i);
            btn.addActionListener(new ActionLIstener(){
                public void actionPerformed(ActionEvent e)
                {
                    String actioncommand=e.getActionCommand();
                    txt.setText(txt.getText() + actionCommand);
                }
            });
            btn.setPerferredSize(new Dimenstion(100,100));  //setSize 와 비슷함
            panel.add(btn);
        }

        pack(); //자동 창맞춤
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
public class KeyPad {
    
}
