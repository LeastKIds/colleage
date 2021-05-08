package test;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
 
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;

 
public class test2 extends JFrame{
 
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setSize(500,600);
        
        try {
            Robot robot = new Robot();
            Rectangle rectangle = new Rectangle(500,500);
            BufferedImage image = robot.createScreenCapture(rectangle);
            image.flush();

            
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
    }
}


