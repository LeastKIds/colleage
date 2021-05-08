package j210507.ch15;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleDictionary extends JPanel implements ActionListener{
    
    // 입력 필드, 버튼 2개
    private JTextField imputField=new JTextField(30);
    private JButton searchBtn=new JButton("검색");
    private JButton addBtn=new JButton("추가");

    // 한영사전 : 한글단어와 대응되는 영어단어의 쌍을 저장
    Map<String, String> dict=new HashMap<>();


    public SimpleDictionary()
    {
        this.add(imputField);
        this.add(searchBtn);
        this.add(addBtn);
        
        searchBtn.addActionListener(this);
        addBtn.addActionListener(this);

        this.setPreferredSize(new Dimension(600,50));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String key=imputField.getText();    // 공통적으로 수행하는 것
        System.out.println("[" + key + "]");
        if(key.trim().length()==0)
            return;
        
        // TODO Auto-generated method stub
        if(e.getSource() == searchBtn)
        {   // 검색 버튼이 클릭 된 경우
            /*
                inputField에 입력된 단어를 추출
                dict 맵 객체에서 그 단어에 대응되는 
                영어 단어를 찾아 디스플레이.
            */
            String value = dict.get(key);
            if(value == null)   // 그 key에 대응되는 영단어가 없는 경우
            {   // 없다고 디스플레이
                JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다.", key, JOptionPane.ERROR_MESSAGE);
            }else
            {   // 대응되는 단어를 디스플레이
                JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);

            }
        }else if(e.getSource() == addBtn)
        {   // 추가 버튼이 클릭된 경우
            /*
                imputField에 입력된 단어를 추출
                그 단어에 대응되는 영어 단어를 입력받고
                dict 맵 객체에 <한글단어, 영어단어>의 쌍을 추가
            */
            String value=JOptionPane.showInputDialog(this, key + "에 대응되는 영어단어를 입력하세요.");
            if(value==null || value.trim().length() == 0 )
                return;
            dict.put(key,value);
            dict.put(value,key);
            JOptionPane.showMessageDialog(this, "영어 단어가 추가되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);

        }

        imputField.requestFocus();
        
    }

    public static void main(String[] args)
    {
        JFrame frame=new JFrame();
        frame.add(new SimpleDictionary());

        frame.setTitle("나의 한영사전");
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
