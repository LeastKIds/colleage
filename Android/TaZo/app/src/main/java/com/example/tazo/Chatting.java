package com.example.tazo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Chatting extends AppCompatActivity implements View.OnClickListener, ReceiverThread.OnReceiveListener {

    private TextView mMessageTextView;
    private EditText mMessageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mMessageTextView = (TextView) findViewById(R.id.message_text);
        mMessageEditText = (EditText) findViewById(R.id.message_edit);
        findViewById(R.id.send_button).setOnClickListener(this);


        try {
            // 일단은 테스트 용으로 본인의 아이피를 입력해서 진행하겠습니다.
            Socket socket = new Socket("localhost", 7777);
            // 두번째 파라메터 로는 본인의 닉네임을 적어줍니다.
            SenderThread thread1 = new SenderThread(socket, "android");
            ReceiverThread thread2 = new ReceiverThread(socket);

            thread2.setOnReceiveListener(this);
            thread1.start();
            thread2.start();

        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 보내는 거
    @Override
    public void onClick(View v) {

    }

    // 받는 거
    @Override
    public void onReceive(String message) {
        String msg = mMessageTextView.getText().toString();
        mMessageTextView.setText(msg + "\n" + message);
    }
}

class ReceiverThread extends Thread {

    interface OnReceiveListener {
        void onReceive(String message);
    }

    public void setOnReceiveListener(OnReceiveListener listener)
    {
        mListener = listener;
    }
    OnReceiveListener mListener;
    Socket socket;

    public ReceiverThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            // Input 상대방 내용이 나에게 들어올 때.
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                String str = reader.readLine();
                if (str == null) {
                    break;
                }
                
                // 출력
                System.out.println(str);
                if(mListener != null)
                    mListener.onReceive(str);
            }

        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

/**
 * 메시지의 발신을 담당하는 스레드 입니다.
 */

class SenderThread extends Thread {
    Socket socket;
    String name;

    public SenderThread(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    public void close()
    {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void run() {

        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            // 제일 먼저 서버로 대화명을 송신합니다.
            // 맨 먼저 간 값이 닉네임이 되기 때문.
            writer.println(name);
            writer.flush();

//            while (true) {
//                String str = reader.readLine();
//                if (str.equals("bye")) {
//                    break;
//                }
//                writer.println(str);
//                writer.flush();
//            } 안드로이드에선 필요 없음

        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        finally {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }

    }

}