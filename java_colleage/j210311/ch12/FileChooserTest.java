package j210311.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FileChooserTest extends JFrame implements ActionListener{

    JButton openButton, saveButton;
    JFileChooser fc;

    public FileChooserTest()
    {
        this.setTitle("File selecter test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);

        fc=new JFileChooser();

        JLabel label=new JLabel("File Selecter Component Test");
        openButton=new JButton("File Open");
        openButton.addActionListener(this);

        saveButton=new JButton("File Save");
        saveButton.addActionListener(this);

        JPanel panel=new JPanel();
        panel.add(label);
        panel.add(openButton);
        panel.add(saveButton);
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==openButton)
        {
            int returnVal=fc.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file=fc.getSelectedFile();
            }
            else
            {}

        }
        else if(e.getSource() == saveButton)
        {
            int returnVal=fc.showSaveDialog(this);
            if(returnVal==JFileChooser.APPROVE_OPTION)
            {
                File file=fc.getSelectedFile();
            }
            else
            {}

        }
    }

    public static void main(String[] args)
    {
        FileChooserTest frame=new FileChooserTest();
    }
    
}
