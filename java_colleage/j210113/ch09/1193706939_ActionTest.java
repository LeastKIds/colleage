import java.applet.Applet;
import java.awt.*;
import java.awt.event.*; 

/* <APPLET CODE=ActionTest WIDTH=300 HEIGHT=300></APPLET> */

public class ActionTest extends Applet implements ActionListener{
	Button myBtn;
	Button myClsBtn;
	Label myLbl;
	TextField myTxt;
	Panel myPnl; 

	public void init(){
		myPnl = new Panel();
		myPnl.setLayout(new GridLayout(3, 1));

		myBtn = new Button("�̸��� �Է��ϰ� Click!");
		myClsBtn = new Button("�ٽ� �Է��Ͻʽÿ�");
		myTxt = new TextField();
		
		myPnl.add(myTxt);
		myPnl.add(myBtn);
		myPnl.add(myClsBtn);

		setLayout(new BorderLayout());
		myLbl = new Label("", Label.CENTER);
		
		add ("North", myPnl);
		add("Center", myLbl);

		myBtn.addActionListener(this);
		myClsBtn.addActionListener(this); 
	}

	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();

		if(o == myBtn){
			myLbl.setText(myTxt.getText()+"��, �ȳ��ϼ���!");
		}else{
			myLbl.setText("");
			myTxt.setText("");
		}
	}
}