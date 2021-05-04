// package j210201.ch10;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.awt.image.*;
// import java.io.*;
// import javax.imageio.*;
// import java.awt.image.*;
// import javax.imageio.*;

// public class CarGame3 extends JFrame{
//     public CarGame3()
//     {
//         this.setSize(300,300);
//         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         this.add(new MyPanel3());
//         this.setVisible(true);
//     }
// }

// class MyPanel3 extends JPanel
// {
//     private BufferedImage img=null;
//     private int imgX=100, imgy=100;
//     public MyPanel3()
//     {
//         try{
//             img=ImageIo.read(new File("car.jpg"));
//         } catch(IOException e)
//         {
//             System.out.println();
//             System.exit(1);
//         }
//     }
// }
