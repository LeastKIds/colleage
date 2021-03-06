// package j210305.ch11;


// import java.awt.Color;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JTextField;

// class DrawPanel extends JPanel{
   
//    public DrawPanel() {
//       setBounds(0, 50, 500, 400);
//    }

//    public void paintComponent(Graphics g) {
//       super.paintComponent(g);
//       Graphics2D g2 = (Graphics2D) g;
//       g2.drawLine(10, 175, 490, 175);
//       g2.drawLine(250, 10, 250, 340);
//       g2.setPaint(Color.RED);
//       for (int i = -200; i < 200; i++) {
//          int x = i;
//          int y = (int) (QuandraticFunction.A * x * x + QuandraticFunction.B * x + QuandraticFunction.C);
//          g2.fillOval(250 + x - 2, 175 - (y - 2), 4, 4);
//       }
//       System.out.printf("%f, %f, %f\n" , QuandraticFunction.A, QuandraticFunction.B, QuandraticFunction.C);
//       System.out.println("===========================");
//    }

// }

// public class QuandraticFunction extends JPanel implements ActionListener {
//    DrawPanel drawPanel = new DrawPanel();
//    JTextField a, b, c;
//    public static double A, B, C;
   
//    public QuandraticFunction() {
//       a = new JTextField("1.0", 10);
//       b = new JTextField("-5.0", 10);
//       c = new JTextField("6.0", 10);
//       add(a);
//       add(b);
//       add(c);
//       JButton button = new JButton("DRAW");
//       add(button);
//       button.addActionListener(this);
//       setBounds(0, 0, 500, 50);
//    }

//    @Override
//    public void actionPerformed(ActionEvent arg0) {
//       System.out.println(1234);
//       A = Double.parseDouble(a.getText());
//       B = Double.parseDouble(b.getText());
//       C = Double.parseDouble(c.getText());
//       System.out.printf("%f, %f, %f", A, B, C);
// //      repaint();
//    }

//    public static void main(String[] args) {
//       JFrame f = new JFrame();
//       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//       f.add(new QuandraticFunction());
//       f.add(new DrawPanel());
//       f.setLayout(null);
//       f.setSize(500, 400);
//       f.setVisible(true);
//    }
// }
