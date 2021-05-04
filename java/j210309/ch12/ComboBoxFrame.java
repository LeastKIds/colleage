package j210309.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboBoxFrame extends JFrame implements ActionListener{
    JLabel label;

    public ComboBoxFrame()
    {
        this.setTitle("Combo Box");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);

        String[] animals={"dog", "lion","tiger"};
        JTextField field=new JTextField();
        JComboBox animalList=new JComboBox(animals);
        animalList.setSelectedIndex(0);
        animalList.addActionListener(this);

        label=new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        changePicture(animals[animalList.getSelectedIndex()]);
        this.add(animalList, BorderLayout.PAGE_START);
        this.add(label, BorderLayout.PAGE_END);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JComboBox cb=(JComboBox) e.getSource();
        String name=(String) cb.getSelectedItem();
        changePicture(name);
    }

    protected void changePicture(String name)
    {
        ImageIcon icon=new ImageIcon("./j210309/"+name + ".gif");
        label.setIcon(icon);
        if(icon !=null)
            label.setText(null);
        else
            label.setText("No Image");
    }

    public static void main(String[] args)
    {
        ComboBoxFrame frame=new ComboBoxFrame();
    }
}
