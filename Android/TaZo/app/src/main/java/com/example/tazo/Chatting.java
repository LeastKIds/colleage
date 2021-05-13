package com.example.tazo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Chatting extends AppCompatActivity {

    private Message msg;
    static int testNum=0;


    private ArrayList<ChattingData> arrayList;
    private ChattingAdapter chattingAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayout;

    private Button send_button_test;
    private EditText message_edit_test;
    private TextView message_text_test;

    String sumStr="";
    String name="안드로이드";
    String otherName="이클립스";

    ReceiverThread thread1;

    ChattingData chatData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        send_button_test = findViewById(R.id.send_button_test);
        message_edit_test = (EditText) findViewById(R.id.message_edit_test);


        ConectNet conectNet = new ConectNet(name);
        conectNet.execute();

        recyclerView = (RecyclerView) findViewById(R.id.chatting_test);
        linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);

        arrayList = new ArrayList<>();

        chattingAdapter = new ChattingAdapter(arrayList);
        recyclerView.setAdapter(chattingAdapter);

        RecyclerDecoration spaceDecoration = new RecyclerDecoration(30);
        recyclerView.addItemDecoration(spaceDecoration);




        send_button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumStr=message_edit_test.getText().toString();
                message_edit_test.setText("");


                testNum = 1;




            }
        });


//        recyclerView.scrollToPosition(ChattingAdapter.getItemCount()-1);



    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg){
            System.out.println("일단 handler는 실행 됨");
            if(msg.what==1)
            {
                String messageStr=(String)msg.obj;
                chatData = new ChattingData(R.drawable.ic_launcher_background, otherName, messageStr);
                arrayList.add(chatData);
                chattingAdapter.notifyDataSetChanged();

            }

        }
    };

    class ReceiverThread extends Thread {
        Socket socket;
        public ReceiverThread(Socket socket) {
            this.socket = socket;
        }



        @Override
        public void run() {

            System.out.println("ReceiverThread 실행");



            try {





                // Input 상대방 내용이 나에게 들어올 때.
                BufferedReader readerOut = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
                while (true) {

                    String str = readerOut.readLine();

                    msg = handler.obtainMessage();
                    msg.what=1;
                    msg.obj=str;
                    handler.sendMessage(msg);



                }

            }

            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public class SenderThread extends Thread
    {
        PrintWriter writer;
        String name;
        Socket socket;

        public SenderThread (Socket socket, String name)
        {
            this.socket = socket;
            this.name = name;
        }

        @Override
        public void run()
        {
            System.out.println("SenderThread 실행 중");

            try{
                BufferedReader readerIn = new BufferedReader(new InputStreamReader(System.in, "utf-8"));

                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));

                // 제일 먼저 서버로 대화명을 송신합니다.
                // 맨 먼저 간 값이 닉네임이 되기 때문.
                writer.println(name);
                writer.flush();
                System.out.println("이름 보냇음");
                while(true)
                {
                    if(testNum==1)
                    {

                        writer.println(sumStr);
                        writer.flush();
                        testNum=0;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public class ConectNet extends AsyncTask
    {
        String name;
        public ConectNet(String name)
        {
            this.name=name;
        }

        @Override
        protected Void doInBackground(Object[] objects) {
            
            System.out.println("AsyncTask 실행중");
            try{
                Socket socket = new Socket("10.0.2.2", 7777);
                ReceiverThread thread1 = new ReceiverThread(socket);
                SenderThread thread2 = new SenderThread(socket,name);
                thread1.start();
                thread2.start();

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}

