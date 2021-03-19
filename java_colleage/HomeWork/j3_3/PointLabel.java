package HomeWork.j3_3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//점수판 라벨
public class PointLabel extends JLabel{ 
    
    private int point1=0;
    private int point2=0;   // 혹시 초기화가 안됬다는 오류가 뜰까봐 0으로 초기화
    
    // 맨 처음 점수판 0:0
    public PointLabel()
    {

        this.setText("0 : 0");
    }

    // 외부에서 점수를 받아오는 메소드
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

