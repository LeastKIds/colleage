package j210315.ch13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PointLabel extends JLabel{
    
    private int point1=0;
    private int point2=0;
    public PointLabel()
    {

        this.setText("0 : 0");
    }

    void setPoint(int point1, int point2)
    {
        this.point1=point1;
        this.point2=point2;
        
    }

    void setPointPanel()
    {
        this.setText(point1 + " : " + point2);
    }
}
