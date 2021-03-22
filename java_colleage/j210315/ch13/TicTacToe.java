// package j210315.ch13;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

// public class TicTacToe extends JPanel implements ActionListener{
//     JButton[][] buttons=new JButton[3][3];
//     private char turn='X';

//     public TicTacToe()
//     {
//         this.setLayout(new GridLayout(3,3,5,5));
//         Font f=new Font("Dialog", Font.ITALIC,50);

//         for(int i=0; i<3; i++)
//             for(int j=0; j<3; j++)
//             {
//                 buttons[i][j]=new JButton(" ");
//                 buttons[i][j].setFont(f);
//                 buttons[i][j].addActionListener(this);
//                 this.add(buttons[i][j]);
//             }
//     }

// 	@Override
// 	public void actionPerformed(ActionEvent e) {
// 		// TODO Auto-generated method stub
// 		for(int i=0; i<3; i++)
//             for(int j=0; j<3; j++)
//             {
//                 if(e.getSource()==buttons[i][j] && buttons[i][j].getText().equals(" ") ==true)
//                 {
//                     if(turn == 'X')
//                     {
//                         buttons[i][j].setText("X");
//                         turn='O';
//                         if(checkWin("X",i,j))
//                             System.out.println("X가 이겼음!");
//                         else if(isDraw())
//                             System.out.println("비겼음!");
//                         else
//                         {
//                             buttons[i][j].setText("O");
//                             turn='X';
//                             if(checkWin("O",i,j))
//                                 System.out.println("O가 이겼음!");
//                             else if(isDraw())
//                                 System.out.println("비겼음!");
//                         }
                            
//                     }
//                 }
//             }
// 	}

//     public boolean isDraw()
//     {
//         for(int row=0; row<3; ++row)
//             for(int col=0; col<3; ++col)
//                 if(buttons[row][col].getText().equals(" "))
//                     return false;
            
//         return true;
//     }


    
// }
