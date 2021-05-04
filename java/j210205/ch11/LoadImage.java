package j210205.ch11;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class LoadImage extends JPanel{
    static BufferedImage img;

    static{
        try{
            img=ImageIO.read(new File("C:/github/colleage/java_colleage/j210205/galaxy.jpg"));
            } catch(IOException e)
            {
                System.out.println(e.getMessage());
                System.out.println("이미지를 읽을 수 없어 프로그램을 종료합니다.");
                System.exit(1);
    
            }
    }
    public LoadImage()
    {
        try{
        img=ImageIO.read(new File("C:/github/colleage/java_colleage/j210205/galaxy.jpg"));
        } catch(IOException e)
        {
            System.out.println(e.getMessage());
            System.out.println("이미지를 읽을 수 없어 프로그램을 종료합니다.");
            System.exit(1);

        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img,0,0,null);
    }

    public static void main(String[] args)
    {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // LoadImage panel=new LoadImage();
        // frame.add(panel);
        // frame.setSize(panel.img.getWidth(),panel.img.getHeight());
        JLabel label=new JLabel();
        
        label.setIcon(new ImageIcon(img));
        frame.add(label);
        frame.setSize(img.getWidth(),img.getHeight());
        frame.setVisible(true);
    }
    
}
