package j210308.ch12;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

public class CheckBoxPanel extends JPanel implements ItemListener{

    private JCheckBox[] checkBoxes=new JCheckBox[3];
    private String[] fruits={"apple","grapes","orange"};
    private JLabel[] labels=new JLabel[3];
    private ImageIcon[] icons=new ImageIcon[3];

    public CheckBoxPanel()
    {
        this.setLayout(new GridLayout(0,4));

        for(int i=0; i<checkBoxes.length; i++)
        {
            checkBoxes[i]=new JCheckBox(fruits[i]);
            checkBoxes[i].addItemListener(this);
            labels[i]=new JLabel(fruits[i]+".gif");
            icons[i]=new ImageIcon("./j210308/"+fruits[i]+".gif");
        }

        JPanel checkBoxPanel=new JPanel(new GridLayout(0,1));
        for(int i=0; i<checkBoxes.length; i++)
            checkBoxPanel.add(checkBoxes[i]);
        
        this.add(checkBoxPanel);
        for(int i=0; i<labels.length; i++)
            this.add(labels[i]);
    }

    public static void main(String[] args)
    {
        JFrame frame=new JFrame("CheckBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CheckBoxPanel());
        frame.setSize(500,200);
        frame.setVisible(true);

    }







    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        Object source=e.getItemSelectable();

        for(int i=0; i<checkBoxes.length; i++)
        {
            if(source==checkBoxes[i])
            {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    labels[i].setIcon(icons[i]);
                    labels[i].setText(null);
                }
                else
                    labels[i].setIcon(null);
                
            }
        }
    }


    
}
