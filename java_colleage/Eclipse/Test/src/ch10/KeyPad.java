package ch10;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyPad extends JFrame implements ActionListener{

	private JTextField txt;
	private JPanel panel;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
	}

	public KeyPad()
	{
		txt=new JTextField(20);
		this.add(txt,BorderLayout.NORTH);
		panel =new JPanel();
		panel.setLayout(new GridLayout(3,3));
		this.add(panel,BorderLayout.CENTER);
		for(int i=1; i<=9; i++)
		{
			JButton btn=new JButton("" +i);
			btn.addActionListener(this);
			btn.setPreferredSize(new Dimension(100,100));
			panel.add(btn);
		}
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new KeyPad();
	}
}
