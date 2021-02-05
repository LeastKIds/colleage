package j210204.ch11;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class ColorChooserTest extends JFrame implements ChangeListener , ActionListener{

    
    private JColorChooser colorChooser=new JColorChooser();
    private MyDrawingColorPanel drawingPanel=new MyDrawingColorPanel();
    private JButton selectBtn=new JButton("SetColor");
    private JPanel panel=new JPanel();

    public ColorChooserTest()
    {
        this.setTitle("색상 선택기 테스트");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorChooser.getSelectionModel().addChangeListener(this);

        
        panel.add(colorChooser);

        this.add(panel, BorderLayout.CENTER);
        this.add(selectBtn,BorderLayout.SOUTH);
        selectBtn.addActionListener(this);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        System.out.println(colorChooser.getColor());
    }

    public static void main(String[] args)
    {
        JFrame frame=new ColorChooserTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String action=e.getActionCommand(); // 버튼에 있는 텍스트 리턴
        if(action.equals("SetColor"))
        {
            this.remove(panel);
            this.add(drawingPanel ,BorderLayout.CENTER);
            drawingPanel.color=colorChooser.getColor();
            selectBtn.setText("SelectColor");
        }
        else
        {
            this.remove(drawingPanel);
            this.add(panel,BorderLayout.CENTER);
            selectBtn.setText("SetColor");
        }

        //repaint();
    }
    
}

class MyDrawingColorPanel extends JPanel implements MouseMotionListener
{
    Color color=Color.black;
    ArrayList<Point> points =new ArrayList<>();

    class Point
    {
        int x;
        int y;
        Color color;
    }
    public MyDrawingColorPanel()
    {
        this.addMouseMotionListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);

        g.setColor(color);
        for(int i=0; i<points.size(); i++)
        {
            Point p=points.get(i);
            g.setColor(p.color);
            g.drawRect(p.x,p.y,1,1);
        }
            
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        Point p=new Point();

        p.x=e.getX();
        p.y=e.getY();
        p.color=color;

        points.add(p);
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}