package j210308.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageLabelTest extends JFrame implements ActionListener{
    private JPanel panel;
    private JLabel label;
    private JButton button;

    public ImageLabelTest()
    {
        this.setSize(300,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel=new JPanel();
        label=new JLabel("이미지를 보려면 버튼을 누르세요");

        button=new JButton("이미지 보기");
        ImageIcon icon=new ImageIcon("./j210308/icon.jpg");
        button.setIcon(icon);
        button.addActionListener(this);

        panel.add(label);
        panel.add(button);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        ImageIcon dog=new ImageIcon("./j210308/dog.jpg");
        File file=new File("dog.gif");
        System.out.println(file.getAbsolutePath());
        label.setIcon(dog);
        label.setText(null);
    }

    public static void main(String[] args)
    {
        new ImageLabelTest();
    }
}
