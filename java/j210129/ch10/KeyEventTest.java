package j210129.ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventTest extends JFrame implements KeyListener{
    private JPanel panel;
    private JTextField field;
    private JTextArea area;

    public KeyEventTest()
    {
        panel=new JPanel(new GridLayout(0,2));
        panel.add(new JLabel("문자를 입력하시오"));
        field=new JTextField(10);
        panel.add(field);
        field.addKeyListener(this);

        area=new JTextArea(3,30);
        this.add(panel,BorderLayout.NORTH);
        this.add(area, BorderLayout.CENTER);

        this.setSize(400,200);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public static void main(String[] args)
    {
        JFrame frame=new KeyEventTest();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //  방향키 등은 이벤트가 발생 하지 않음
        //  글자 등은 이벤트 발생
        //System.out.println("Key Typed!!");
        display(e,"Key Typed!!!");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("Key Pressed!!");
        display(e,"Key Pressed!!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("KeyReleased");
        display(e,"Key Released!!!");
    }
    private void display(KeyEvent e, String s)
    {
        char c=e.getKeyChar();
        int keycode=e.getKeyCode();

        System.out.println("Event : " + s + ", char : " + c + ", code[" + keycode + "]\n");
        this.area.append("Event : " + s + ", char : " + c + ", code[" + keycode + "]\n");
    }
    
}
