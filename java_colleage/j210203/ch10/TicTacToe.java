package j210203.ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TicTacToe implements ActionListener{

    private Random random = new Random();
    private JFrame frame = new JFrame();
    private JPanel titlePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JLabel titleLabel = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn = false; // true 이면 player 1의 순서, X의 순서임을 나타냄.

    JButton restartBtn = new JButton("Restart");


    public static void main(String[] args) {
        new TicTacToe();
    }


    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        
        titleLabel.setBackground(new Color(25, 25, 25));
        titleLabel.setForeground(new Color(25, 255, 0));

        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 75));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setText("Tic-Tac-Toe");
        titleLabel.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(titleLabel);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setOpaque(true);
            buttons[i].setFocusable(false);
            buttons[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.gray);
            buttonPanel.add(buttons[i]);
        }

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        restartBtn.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 50));
        frame.add(restartBtn, BorderLayout.SOUTH);

        restartBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               for (int i = 0; i < buttons.length; i++) {
                   buttons[i].setText("");
                   buttons[i].setEnabled(true);
                   buttons[i].setBackground(Color.gray);
               }
               titleLabel.setText("Tic-Tac-Toe");
               firstTurn();
            }

        });

        frame.setVisible(true);

        firstTurn();

    }

    private void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {

        }    

        if (random.nextInt(2) == 0) {
            player1Turn = true;
            titleLabel.setText("X turn");
        } else {
            player1Turn = false;
            titleLabel.setText("O turn");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                if (buttons[i].getText().equals("")) {
                    if (player1Turn) { // X turn
                        buttons[i].setForeground(Color.red);
                        buttons[i].setText("X");
                        player1Turn = false;
                        titleLabel.setText("O turn");

                    } else { // O turn
                        buttons[i].setForeground(Color.black);
                        buttons[i].setText("O");
                        player1Turn = true;
                        titleLabel.setText("X turn");
                    }
                    check();
                }
                System.out.println(i + " index button clicked");
            }
        }

    }

    private void check() {
        // x가 이겼으면 
        if (buttons[0].getText().equals("X") &&
            buttons[1].getText().equals("X") &&
            buttons[2].getText().equals("X")) 
                 xWins(0, 1, 2);
        else if (buttons[3].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[5].getText().equals("X"))
                xWins(3, 4, 5);
        else if (buttons[6].getText().equals("X") &&
                buttons[7].getText().equals("X") &&
                buttons[8].getText().equals("X"))
                xWins(6, 7, 8);
        else if (buttons[0].getText().equals("X") &&
                buttons[3].getText().equals("X") &&
                buttons[6].getText().equals("X")) 
                xWins(0, 3, 6);
        else if (buttons[1].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[7].getText().equals("X"))
                xWins(1, 4, 7);
        else if (buttons[2].getText().equals("X") &&
                buttons[5].getText().equals("X") &&
                buttons[8].getText().equals("X"))
                xWins(2, 5, 8);    
        else if (buttons[0].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[8].getText().equals("X"))
            xWins(2, 5, 8);                
        else if (buttons[2].getText().equals("X") &&
                buttons[4].getText().equals("X") &&
                buttons[6].getText().equals("X"))    
                xWins(2, 4, 6);               

        // o가 이겼으면 
        if (buttons[0].getText().equals("O") &&
            buttons[1].getText().equals("O") &&
            buttons[2].getText().equals("O")) 
                 oWins(0, 1, 2);
        else if (buttons[3].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[5].getText().equals("O"))
                oWins(3, 4, 5);
        else if (buttons[6].getText().equals("O") &&
                buttons[7].getText().equals("O") &&
                buttons[8].getText().equals("O"))
                oWins(6, 7, 8);
        else if (buttons[0].getText().equals("O") &&
                buttons[3].getText().equals("O") &&
                buttons[6].getText().equals("O")) 
                oWins(0, 3, 6);
        else if (buttons[1].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[7].getText().equals("O"))
                oWins(1, 4, 7);
        else if (buttons[2].getText().equals("O") &&
                buttons[5].getText().equals("O") &&
                buttons[8].getText().equals("O"))
                oWins(2, 5, 8);    
        else if (buttons[0].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[8].getText().equals("O"))
                oWins(2, 5, 8);                
        else if (buttons[2].getText().equals("O") &&
                buttons[4].getText().equals("O") &&
                buttons[6].getText().equals("O"))    
                oWins(2, 4, 6);               
    }
    

    private void xWins(int a, int b, int c) {

        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < buttons.length; i++) 
            buttons[i].setEnabled(false);

        titleLabel.setText("X wins!");
    }

    private void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < buttons.length; i++) 
        buttons[i].setEnabled(false);

        titleLabel.setText("O wins!");

    }


}

