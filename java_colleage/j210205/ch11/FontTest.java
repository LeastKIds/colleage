package j210205.ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FontTest {
    //static GraphicsEnvironment ge=new GraphicsEnvironment.getLocalGraphicsEnvironment();


    public static void main(String[] args)
    {
        //String[] fontFamilies=ge.getAvailableFontFamilyNames();

        //for(String s : fontFamilies)
            //System.out.println(s);

        Font font=new Font("Times New Roman", Font.BOLD | Font.ITALIC,30);
        Font font2=new Font("Helvetica", Font.BOLD,30);
        JLabel label=new JLabel("Hello everyone?");
        label.setFont(font2); 

        JFrame frame=new JFrame();
        frame.add(label,BorderLayout.NORTH);
        frame.setSize(300,200);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        
    }
}
