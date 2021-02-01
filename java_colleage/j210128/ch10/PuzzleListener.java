package j210128.ch10;

import javax.swing.*;
import java.awt.event.*;

public class PuzzleListener extends JFrame implements ActionListener{
    private JButton[] buttons=new JButton[9];

    public PuzzleListener(JButton[] buttons)
    {
        this.buttons=buttons;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton btn=(JButton)e.getSource();
        int btnN=-1;
        for(int i=0; i<9; i++)
            if(buttons[i].getText().equals(btn.getText()))
                btnN=i;


        if(buttons[btnN].getText().equals("")==true)  
            return;

        if(btnN!=2 && btnN!=5 && btnN!=8 && buttons[btnN+1].getText().equals(""))   //  오른쪽 변
        {
            buttons[btnN+1].setText(buttons[btnN].getText());
            buttons[btnN].setText("");
        }

        if(btnN!=0 && btnN!=3 && btnN!=6 && buttons[btnN-1].getText().equals(""))   //  왼쪽 변
        {
            buttons[btnN-1].setText(buttons[btnN].getText());
            buttons[btnN].setText("");
        }

        if(btnN!=6 && btnN!=7 && btnN!=8 && buttons[btnN+3].getText().equals(""))   //  아래쪽 변
        {
            buttons[btnN+3].setText(buttons[btnN].getText());
            buttons[btnN].setText("");
        }

        if(btnN!=0 && btnN!=1 && btnN!=2 && buttons[btnN-3].getText().equals(""))   //  위쪽 변
        {
            buttons[btnN-3].setText(buttons[btnN].getText());
            buttons[btnN].setText("");
        }
    }
    
}
