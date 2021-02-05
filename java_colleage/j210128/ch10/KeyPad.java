package j210128.ch10;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class KeyPad extends JFrame implements ActionListener {
    private JTextField txt;
    private JPanel panel;

    public KeyPad()
    {
        txt=new JTextField(20);
        add(txt, BorderLayout.NORTH);
        panel=new JPanel();
        panel.setLayout(new GridLayout(3,3));
        add(panel, BorderLayout.CENTER);
        for(int i=1; i<=9; i++)
        {
            JButton btn=new JButton(String.valueOf(i));
            btn.setPreferredSize(new Dimension(100,100));
            panel.add(btn);
            btn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
                    String actionCommand=e.getActionCommand();
                    txt.setText(txt.getText() + actionCommand);
					
				}
                
            });
        }

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        KeyPad pad=new KeyPad();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

   
}
