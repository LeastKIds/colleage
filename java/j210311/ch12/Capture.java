package j210311.ch12;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class Capture {
    JPanel panel;
    BufferedImage image;
    Robot robot;
    JFrame capture;
    JButton button;
    
    
    public Capture()
    {
        capture=new JFrame();
        capture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension d;
        Rectangle rect=new Rectangle(500,500);
        capture.setSize(d=new Dimension(550,650));

        button=new JButton("찰칵");
        capture.add(button, BorderLayout.SOUTH);
        

        JPanel panel=new JPanel()
            {
                public void paintComponent(Graphics g)
                {
                    g.drawImage(image,0,0,500,500,this);
                }
            };
        panel.setOpaque(false);
        panel.prepareImage(image,panel);
        panel.repaint();
        capture.getContentPane().add(panel);

        button.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try
                {
                    Robot robot=new Robot();
                    image=robot.createScreenCapture(new Rectangle(capture.getX(),capture.getY(),1500,1000));
                    image.flush();
                    
                    
                } catch(Exception ea)
                {
                    ea.printStackTrace();
                }
                panel.setOpaque(false);
                panel.repaint();
                capture.repaint();

                
        }    

        });

        

        
           
        

        capture.setVisible(true);
    }


    public static void main(String[] args)
    {
        new Capture();
    }

}
