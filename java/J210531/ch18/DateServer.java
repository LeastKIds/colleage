package J210531.ch18;

import java.net.*;
import java.io.*;
import java.util.*;

public class DateServer {
    public static void main(String[] args)
    {
        try (ServerSocket serverSocket = new ServerSocket(9100)) {
            
            Socket socket = null;
            while(true)
            {
                try {
                    System.out.println("클라이언트의 요청을 기다립니다.");

                socket = serverSocket.accept();
                System.out.println("새로운 클라이언트 접속... [" + socket.getRemoteSocketAddress() + "]");

                OutputStream outStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outStream,true);
                writer.println(Calendar.getInstance().getTime());
           

                }catch (Exception e)
                {
                    e.printStackTrace();
                } finally {
                    socket.close();
                }
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
                  
        
    }
}
