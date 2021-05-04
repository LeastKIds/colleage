package j210309.ch12;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class SliderFrame extends JFrame implements ChangeListener{
    static final int INIT_VALUE=15;
    private JButton buttonOK;
    private JSlider slider;
    private JButton button;

    public SliderFrame()
    {
        JPanel panel;

        this.setTitle("Slider Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel=new JPanel();
        JLabel label=new JLabel("Move Slider", JLabel.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        slider=new JSlider(0,30,INIT_VALUE);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        panel.add(slider);

        button=new JButton(" ");
        ImageIcon icon=new ImageIcon("./j210309/dog.gif");
        button.setIcon(icon);
        button.setSize(INIT_VALUE * 10, INIT_VALUE * 10);
        panel.add(button);
        this.add(panel);

        this.setSize(300,300);
        this.setVisible(true);
    }

    public void stateChanged(ChangeEvent e)
    {
        JSlider source=(JSlider) e.getSource();
        if(!source.getValueIsAdjusting())
        {
            int value=(int) source.getValue();
            button.setSize(value * 10, value * 10);
        }
    }

    public static void main(String[] args)
    {
        new SliderFrame();
    }
}
