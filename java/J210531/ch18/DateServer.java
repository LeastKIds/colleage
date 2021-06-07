package J210531.ch18;

import java.net.*;
import java.io.*;
import java.util.*;

public class DateServer {
    public static void main(String[] args)
    {
        try (ServerSocket serverSocket = new ServerSocket(9100)) {
            
            while(true)
            {
                Socket socket = serverSocket.accept();

                Thread thread = new NewSocket(socket);
                thread.start();
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }

        
                  
        
    }
}

class NewSocket extends Thread {
    Socket socket;

    public NewSocket(Socket socket)
    {
        this.socket = socket;
    }
    public void run() {
        try {
            OutputStream outStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outStream,true);
            writer.println(Calendar.getInstance().getTime());
       
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            try { 
                Thread.sleep(10000);
                socket.close();
                System.out.println("클라이언트와 접속을 종료합니다");
            } catch(Exception e) {}
        }
    }
}
