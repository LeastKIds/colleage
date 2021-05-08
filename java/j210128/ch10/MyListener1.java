package j210128.ch10;

import java.awt.event.*;

import javax.swing.JButton;

public class MyListener1 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button=(JButton)e.getSource();  //  이벤트가 발생한 객체가 Object 타입으로 반환된다.
        button.setText("버튼이 눌려졌습니다.");
    }
    
}
