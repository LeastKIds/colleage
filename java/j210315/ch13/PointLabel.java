package j210315.ch13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//점수판 라벨
public class PointLabel extends JLabel{ 
    
    private int point1=0;
    private int point2=0;   // 혹시 초기화가 안된다는 오류가 뜰까봐 0으로 초기화
    public PointLabel()
    {

        this.setText("0 : 0");
    }

    void setPoint(int point1, int point2)
    {
        this.point1=point1;
        this.point2=point2;
        
    }

    // 점수판 바꿔주는 메소드
    void setPointPanel()
    {
        this.setText(point1 + " : " + point2);
    }
}
