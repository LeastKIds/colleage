package j210311.ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MyFrame2 extends JFrame implements ActionListener
{
    private int sum,temp1,temp2,temp3;
    private JButton order_button, cancle_button;

    private JPanel down_panel;
    private JTextField text;

    WelcomPanel welcom_panel=new WelcomPanel();

    TypePanel type_panel=new TypePanel();
    ToppingPanel topping_panel=new ToppingPanel();
    SizePanel size_panel=new SizePanel();

    public MyFrame2()
    {
        this.setSize(500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pizza Order");

        this.order_button=new JButton("Order");
        this.order_button.addActionListener(this);
        this.cancle_button=new JButton("Cancle");
        this.cancle_button.addActionListener(this);

        this.text=new JTextField();
        text.setEditable(false);
        text.setColumns(6);

        down_panel=new JPanel();
        down_panel.add(this.order_button);
        down_panel.add(this.cancle_button);
        down_panel.add(this.text);

        this.setLayout(new BorderLayout());

        this.add(welcom_panel, BorderLayout.NORTH);
        this.add(down_panel, BorderLayout.SOUTH);
        this.add(size_panel, BorderLayout.EAST);
        this.add(type_panel, BorderLayout.WEST);
        this.add(topping_panel, BorderLayout.CENTER);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==this.order_button)
        {
            sum=type_panel.typeResult() + topping_panel.toppingResult() + size_panel.sizeResult();
            this.text.setText(""+sum);
        }
        if(e.getSource() == this.cancle_button)
        {
            sum=0;
            this.text.setText(""+sum);
        }
    }
}

class WelcomPanel extends JPanel
{
    private JLabel message;

    public WelcomPanel()
    {
        message=new JLabel("자바 피자에 오신것을 환영합니다.");
        this.add(message);
    }
}

class TypePanel extends JPanel implements ActionListener
{
    private JRadioButton combo, potato, bulgogi;
    private ButtonGroup bg;
    int result=10000;

    public TypePanel()
    {
        this.setLayout(new GridLayout(3,1));

        combo=new JRadioButton("콤보 10000원",true);
        potato=new JRadioButton("포테이토 12000원");
        bulgogi=new JRadioButton("불고기 13000원");

        bg=new ButtonGroup();
        bg.add(combo);
        bg.add(potato);
        bg.add(bulgogi);

        this.setBorder(BorderFactory.createTitledBorder("종류"));
        this.add(combo);
        this.add(potato);
        this.add(bulgogi);
        combo.addActionListener(this);
        potato.addActionListener(this);
        bulgogi.addActionListener(this);
    }

    public int typeResult()
    {
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method 
        System.out.println("Type test");
        
        if(e.getSource()==combo)
            result=10000;
        else if(e.getSource()==potato)
            result=12000;
        else if(e.getSource()==bulgogi)
            result=13000;
    }
}

class ToppingPanel extends JPanel implements ActionListener
{
    private JRadioButton pepper, cheese, peperoni, bacon;
    private ButtonGroup bg;
    int result=1000;

    public ToppingPanel()
    {
        this.setLayout(new GridLayout(4,1));

        pepper=new JRadioButton("피망 1000원",true);
        cheese=new JRadioButton("치즈 2000원");
        peperoni=new JRadioButton("페퍼로니 2000원");
        bacon=new JRadioButton("베이컨 2500원");

        bg=new ButtonGroup();
        bg.add(pepper);
        bg.add(cheese);
        bg.add(peperoni);
        bg.add(bacon);

        this.setBorder(BorderFactory.createTitledBorder("추가 토핑"));

        this.add(pepper);
        this.add(cheese);
        this.add(peperoni);
        this.add(bacon);

        pepper.addActionListener(this);
        cheese.addActionListener(this);
        peperoni.addActionListener(this);
        bacon.addActionListener(this);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        System.out.println("topping test");
        if(e.getSource()==pepper)
            result=1000;
        else if(e.getSource()==cheese)
            result=2000;
        else if(e.getSource()==peperoni)
            result=2000;
        else if(e.getSource()==bacon)
            result=2500;
    }

    public int toppingResult()
    {
        return result;
    }
}

class SizePanel extends JPanel implements ActionListener
{
    private JRadioButton small, medium, large;
    private ButtonGroup bg;
    private int result=0;

    public SizePanel()
    {
        this.setLayout(new GridLayout(3,1));

        small=new JRadioButton("small +0원",true);
        medium=new JRadioButton("medium +3000원");
        large=new JRadioButton("large + 5000원");

        this.setBorder(BorderFactory.createTitledBorder("크기"));

        bg=new ButtonGroup();
        bg.add(small);
        bg.add(medium);
        bg.add(large);

        this.add(small);
        this.add(medium);
        this.add(large);

        small.addActionListener(this);
        medium.addActionListener(this);
        large.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==small)
            result=0;
        else if(e.getSource()==medium)
            result=3000;
        else if(e.getSource()==large)
            result=5000;
        
    }

    public int sizeResult()
    {
        return result;
    }

    
}

public class PizzaTest
{
    public static void main(String[] args)
    {
        MyFrame2 f=new MyFrame2();
    }
}