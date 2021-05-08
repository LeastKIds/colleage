package j210205.ch11;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import javax.imageio.*;

public class ImagePuzzle extends JFrame implements ActionListener{
    private int pieces=4;

    private int totalPieces=pieces*pieces;
    private BufferedImage img;
    private ArrayList<Integer> pieceNumbs=new ArrayList<>();

    public static void main(String[] args)
    {
        new ImagePuzzle();
    }

    public ImagePuzzle()    //  constructor
    {
        this.setTitle("Puzzle Game");
        try{
            img=ImageIO.read(new File("C:/github/colleage/java_colleage/j210205/galaxy.jpg"));
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        for(int i=0; i<totalPieces; i++)
            pieceNumbs.add(i);
        
        // shuffle();
        this.add(new ImagePanel(), BorderLayout.CENTER);
        JButton imgDivideButton=new JButton("img divide");
        this.add(imgDivideButton, BorderLayout.SOUTH);

        imgDivideButton.addActionListener(this);
        this.setSize(img.getWidth(),img.getHeight()+30);
        System.out.println(pieceNumbs);


        this.setVisible(true);
    }



    private void shuffle()
    {
        

        Collections.shuffle(pieceNumbs);

        System.out.println(pieceNumbs);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        shuffle();
        repaint();

    }

    class ImagePanel extends JPanel implements MouseListener
    {

        private int pieceHeight;
        private int pieceWidth;
        
        private int priorClickedNum=-1;
        public ImagePanel()
        {
            this.addMouseListener(this);
        }


        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            pieceWidth=img.getWidth()/pieces;
            pieceHeight=img.getHeight()/pieces;
            int idx=0;

            for(int x=0; x<pieces; x++)
            {
                
                for(int y=0; y<pieces; y++)
                {
                    int sx=pieceNumbs.get(idx) / pieces * pieceWidth;  // 0
                    int sy=pieceNumbs.get(idx) % pieces * pieceHeight; // 4*piexeHeight
                    int dx=x*pieceWidth;
                    int dy=y*pieceHeight;

                    g.drawImage(img, dx, dy, dx+pieceWidth, dy+pieceHeight, sx, sy, sx+pieceWidth, sy+pieceHeight , null);
                    idx++;
                
                }
            }
            
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            int x=e.getX();
            int y=e.getY();

            int col=x/pieceWidth;
            int row=y/pieceHeight;
            // (col, row) : (1,1) => 5 : col * pieces + row
            int clickedPiece=col * pieces + row;

            if(priorClickedNum==-1)
            {
                priorClickedNum=clickedPiece;
            }
            else
            {
                if(priorClickedNum == clickedPiece)
                    priorClickedNum= -1;
                else
                {
                    int tem=pieceNumbs.get(priorClickedNum);
                    pieceNumbs.set(priorClickedNum,pieceNumbs.get(clickedPiece));
                    pieceNumbs.set(clickedPiece,tem);

                    priorClickedNum=-1;

                    repaint();
                }
            }

            
            System.out.println(clickedPiece + "가 클릭되었습니다.");

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }
    }
    
}


