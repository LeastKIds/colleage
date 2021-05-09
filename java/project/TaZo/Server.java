package project.TaZo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.*;;

public class Server {
    private ServerSocket serverSocket;
    private Socket mSoket;
    
    private BufferedReader mIn;    // 
    private PrintWriter mOut;  // 

    public Server()
    {
        try{
            serverSocket = new ServerSocket(7777);
            // 
            System.out.println("Server...");

            // 
            mSoket = serverSocket.accept();
            System.out.println("Conecting!!!");

            mIn = new BufferedReader(new InputStreamReader(mSoket.getInputStream()));

            mOut= new PrintWriter(mSoket.getOutputStream());

            // 
            System.out.println(mIn.readLine());

            // 
            mOut.println("서버 쪽이에요!!!");

            mOut.flush();   // 

            


        }catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public static void main(String[] args)
    {
        new Server();
    }
}
