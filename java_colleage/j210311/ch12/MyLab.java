package j210311.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyLab extends JFrame{
    JComboBox test=new JComboBox();
    private int settingNumber=0;
    boolean overlap=true;
    int n=0;
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
        JButton button=new JButton("test");
        this.add(button);
        ArrayList array=new ArrayList();
        button.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.out.println(settingNumber);
            }
            
        });
        test.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
                
                if(e.getSource()==test)
                {
                    String compare1;
                    String compare2;
                
                    array.add((String)test.getSelectedItem());
                    System.out.println(array);
                    
                    if(settingNumber!=0)
                    {
                        
                        compare1=(String)array.get(settingNumber-1);
                        compare2=(String)array.get(settingNumber);
                        if(!compare1.equals(compare2))
                            overlap=true;
                        else 
                            overlap=false;

                    }
                    else if(settingNumber==0)
                    {
                        overlap=true;
                    }

                    if(!overlap)
                    {
                        test.insertItemAt((String)array.get(settingNumber),n);
                        n++;
                    }
                    settingNumber++;

                    
                    
                }

                
            }
            
        });
        this.setSize(500,500);
        this.setVisible(true);
    }
    
	
    
}
