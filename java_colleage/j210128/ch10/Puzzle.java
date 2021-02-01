package j210128.ch10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Puzzle extends JFrame{
    private JButton[] buttons=new JButton[9];
    private JButton botButton;
    private JPanel panel;
    private JPanel botPanel;

    public Puzzle()
    {
        panel=new JPanel();
        panel.setLayout(new GridLayout(3,3));

        //buttons=new JButton[9];
        for(int i=0; i<8; i++)
        {
            //buttons[i].setText(""+(i+1));
            buttons[i]=new JButton(""+(i+1));
            //buttons[i].setPreferredSize(new Dimension(100,100));
            panel.add(buttons[i]);
        }
        buttons[8]=new JButton("");
        panel.add(buttons[8]);

        //PuzzleListener pl=new PuzzleListener(buttons);
        for(int i=0; i<9; i++)
            buttons[i].addActionListener(new PuzzleListener(buttons));

        // botPanel=new JPanel();
        // botButton=new JButton("reset");
        // botPanel.add(botButton);
        // panel.add(botPanel);
        botButton=new JButton("reset");
        this.add(botButton, BorderLayout.SOUTH);
        botButton.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) {
                for(int i=0; i<9; i++)
                    buttons[i].setText(""+(i+1));
                buttons[8].setText("");
				
			}
            
        });

        //this.pack();
        this.setSize(300,300);
        this.add(panel);
        //this.add(botPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        Puzzle puzzle=new Puzzle();
    }
}
