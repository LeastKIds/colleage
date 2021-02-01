package j210129.ch10;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class CarGame2 extends JFrame{
    
}

class MyPanel extends JPanel implements KeyListener
{
    private BufferedImage img = null;
    private int imgX=100, imgY=100;

    public MyPanel()
    {
        try{
        img=ImageIO.read(new File("car.jpg"));
        } catch(IOException e)
        {
            System.out.println("No image");
            System.exit(1);
        }
        this.addKeyListener(this);
        
        this.setFocusable(true);
        this.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP :
                imgLabel.setLocation(imgLabel.getX(),imgLabel.getY()-10);
                break;
            case KeyEvent.VK_DOWN :
                imgLabel.setLocation(imgLabel.getX(),imgLabel.getY()+10);
                break;
            case KeyEvent.VK_LEFT  :
                imgLabel.setLocation(imgLabel.getX()-10,imgLabel.getY());
                break;
            case KeyEvent.VK_RIGHT :
                imgLabel.setLocation(imgLabel.getX()+10,imgLabel.getY());
                break;
        }

        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
