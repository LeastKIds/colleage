package j210205.ch11;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ImagePuzzle1 extends JFrame implements ActionListener {
    private int pieces = 4;
    private int totalPieces = pieces * pieces;
    private BufferedImage img;
    private ArrayList<Integer> pieceNums = new ArrayList<>();

    public static void main(String[] args) {
        new ImagePuzzle1();
    }

    public ImagePuzzle1() { // constructor
        this.setTitle("Puzzle Game");
        try {
            img = ImageIO.read(new File("C:/github/colleage/java_colleage/j210205/galaxy.jpg"));
        }catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // shuffle();
        for (int i = 0; i < totalPieces; i++)
            pieceNums.add(i);

        this.add(new ImagePanel(), BorderLayout.CENTER);
        JButton imgDivideBtn = new JButton("이미지 쪼개기");
        this.add(imgDivideBtn, BorderLayout.SOUTH);

        imgDivideBtn.addActionListener(this);
        this.setSize(img.getWidth(), img.getHeight()+30);
        this.setVisible(true);

    }

    private void shuffle() {
        Collections.shuffle(pieceNums);

        System.out.println(pieceNums);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       shuffle();
       repaint();

    }

    class ImagePanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int pieceWidth = img.getWidth() / pieces;
            int pieceHeight = img.getHeight() / pieces;

            for (int x = 0; x < pieces; x++) {
                for (int y = 0; y < pieces; y++) {
                    int sx = pieceNums.get(x*pieces + y)/pieces * pieceWidth;
                    int sy = pieceNums.get(x*pieces + y)%pieces * pieceHeight;

                    int dx = x * pieceWidth;
                    int dy = y * pieceHeight;

                    g.drawImage(img, dx, dy, dx+pieceWidth, dy+pieceHeight, sx, sy, sx+pieceWidth, sy+pieceHeight, null);
                }
            }
        }
    }
    
}


