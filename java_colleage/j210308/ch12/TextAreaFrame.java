package j210308.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreaFrame extends JFrame implements ActionListener{

    protected JTextField textField;
    protected JTextArea textArea;

    public TextAreaFrame()
    {
        this.setTitle("Text Area Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField=new JTextField(30);
        textField.addActionListener(this);

        textArea=new JTextArea(10,30);
        JScrollPane scrollPane=new JScrollPane(textArea);
        this.add(scrollPane,BorderLayout.CENTER);
        textArea.setEditable(false);

        this.add(textField, BorderLayout.NORTH);
        //this.add(textArea, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String text=textField.getText();
        textArea.append(text + "\n");
        textField.selectAll();
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public static void main(String[] args)
    {
        new TextAreaFrame();
    }
    
}
