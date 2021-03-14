package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyLab extends JFrame implements ActionListener{
    JComboBox test=new JComboBox();
    private int settingNumber=0;
    public static void main(String[] args)
    {
       MyLab frame=new MyLab();
    }

    ArrayList<String> array=new ArrayList<>();
    public MyLab()
    {

        
        test.setEditable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(test, BorderLayout.PAGE_START);
        test.addActionListener(this);
        this.setSize(500,500);
        this.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        
        if(e.getSource()==test)
            test.insertItemAt(test.getSelectedItem(),settingNumber);
		
	}
    
}
