package project.TaZo;

import java.io.*;

import java.net.Socket;


public class Client {
    private Socket mSocket;

    private BufferedReader mIn;
    private PrintWriter mOut;

    public Client(String ip, int port)
    {
        try{
            // 서버에 요청 보내기
            mSocket = new Socket(ip,port);
            System.out.println("서버 연결");

            // 통로 뚫기
            mIn=new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
            mOut=new PrintWriter(mSocket.getOutputStream());

            // 메세지 전달
            mOut.println("클라이언트 쪽이에요!!");
            mOut.flush();

            // 응답 출력
            System.out.println(mIn.readLine());


        } catch(IOException e){
            e.printStackTrace();
        } finally {
            // 소캣 닫기 (연결 끊기)
            System.out.println("끊습니다...");
            try{
                mSocket.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
            
        }
    }

    public static void main(String[] args)
    {
        new Client("localhost", 7777);
    }
}
