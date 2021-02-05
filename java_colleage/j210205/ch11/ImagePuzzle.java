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
        this.setSize(623,352+30);
        System.out.println(img.getWidth()+","+img.getHeight());


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

    class ImagePanel extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            int pieceWidth=img.getWidth()/pieces;
            int pieceHeight=img.getHeight()/pieces;

            for(int x=0; x<pieces; x++)
            {
                
                for(int y=0; y<pieces; y++)
                {
                    int sx=pieceNumbs.get(x*pieces + y) / pieces * pieceWidth;
                    int sy=pieceNumbs.get(x*pieces + y) / pieces * pieceHeight;
                    int dx=x*pieceWidth;
                    int dy=y*pieceHeight;

                    g.drawImage(img, dx, dy, dx+pieceWidth, dy+pieceHeight, sx, sy, sx+pieceWidth, sy+pieceHeight , null);
                
                
                }
            }
            
        }
    }
    
}


