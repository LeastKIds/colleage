package j210129.ch10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class CarGame extends JFrame implements KeyListener{
    private JLabel imgLabel;

    public CarGame()
    {
        setSize(300,300);
        imgLabel=new JLabel();
        ImageIcon imageIcon=new ImageIcon("./car.jpg");
        imgLabel.setIcon(imageIcon);

        this.add(imgLabel);
        this.addKeyListener(this);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        JFrame frmae=new CarGame();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
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
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
