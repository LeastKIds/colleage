// package j210201.ch10;


// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;


// public class MyFrame extends JPanel{
//     public MyFrame()
//     {
//         this.add(new MyPanel());
//         this.setSize(300,500);
//         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         this.setVisible(true);
//     }

//     public static void main(String[] args)
//     {
//         MyFrame frame=new MyFrame();
//     }
    
// }

// class MyPanel extends JPanel implements ActionListener
// {
//     private int lightNumber=-1;
//     public MyPanel()
//     {
//         this.setLayout(new BorderLayout());
//         JButton b=new JButton("traffic light turn on");
//         b.addActionListener(this);
//         this.add(b, BorderLayout.SOUTH);
//     }

//     @Override
//     protected void paintComponent(Graphics g) {
//         // TODO Auto-generated method stub
//         super.paintComponent(g);
//         System.out.println("paintComponent Called...");

//         g.setColor(Color.black);
//         g.drawOval(100,100,100,100);
//         g.drawOval(100,200,100,100);
//         g.drawOval(100,300,100,100);

//         if(lightNumber==0)
//         {
//             g.setColor(Color.red);
//             g.fillOval(100,100,100,100);
//         }
//         else if(lightNumber==1)
//         {
//             g.setColor(Color.green);
//             g.fillOval(100,200,100,100);
//         }
//         else
//         {
//             g.setColor(Color.yellow);
//             g.fillOval(100,300,100,100);
//         }
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         // TODO Auto-generated method stub
//         //System.out.println("Actionperformed called...");
//         if(++lightNumber >=3)
//             lightNumber=0;
        
//         this.repaint();

//     }
// }
