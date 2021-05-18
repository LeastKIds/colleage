package com.example.tazo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Chatting extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;
    private TextView textView_test;
    private Button socketClose;
    private int socketCloseNumber=0;
    private int socketCloseNumber2=0;
//    ---------------------------------------------------
    private Message msg;
    static int testNum=0;
    JSONObject jsonObject;


    private ArrayList<ChattingData> arrayList;
    private ChattingAdapter chattingAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayout;

    private Button send_button_test;
    private EditText message_edit_test;
    String sumStr="";
    String name="스마트폰1";
    String nameCheck="";
    int inOut=-1;

    ReceiverThread thread1;

    ChattingData chatData;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//-----------------------------------------------------------------------------

        drawerLayout= (DrawerLayout) findViewById(R.id.ChattingActivity);
        drawerView = (View) findViewById(R.id.drawer);

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        textView_test = (TextView) findViewById(R.id.textView_test);
        textView_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button socketClose = (Button) findViewById(R.id.socketClose);
//        ------------------------------------------------------------------
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

                jsonObject=new JSONObject();
                jsonObject.put("content",sumStr);

                testNum = 1;

            }
        });


//        recyclerView.scrollToPosition(ChattingAdapter.getItemCount()-1);


        socketClose = (Button) findViewById(R.id.socketClose);
        socketClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("socket close button");
                socketCloseNumber=1;
                onBackPressed();
            }
        });


    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg){
//            System.out.println("일단 handler는 실행 됨");
            if(msg.what==1)
            {
                String messageStr=(String)msg.obj;

                chatData = new ChattingData(R.drawable.ic_launcher_background, nameCheck, messageStr, name, inOut);
                arrayList.add(chatData);
                chattingAdapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(arrayList.size()-1);

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

                    JSONParser jsonParser=new JSONParser();
                    Object obj = jsonParser.parse(str);
                    JSONObject jsonStr=(JSONObject) obj;

                    if(jsonStr.get("content") == null)
                    {
                        jsonStr = (JSONObject)jsonStr.get("User");
                        nameCheck = (String) jsonStr.get("nickname");
                        System.out.println(123123);
                        System.out.println(nameCheck);
                        str = nameCheck;
//                        str = "#" + jsonStr.get("nickname") + "님이 들어오셨습니다.";
                        inOut=2;
                    }
                    else
                    {
                        str=(String)jsonStr.get("content");
                        jsonStr = (JSONObject)jsonStr.get("User");
                        nameCheck = (String) jsonStr.get("nickname");
                        inOut = 1;
                    }



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

                JSONObject jsonName = new JSONObject();
                jsonName.put("nickname",name);
                JSONObject jsonName2=new JSONObject();
                jsonName2.put("User",jsonName);


                writer.println(jsonName2);
                writer.flush();
                System.out.println("이름 보냇음");
                while(true)
                {
                    if(testNum==1)
                    {
                        System.out.println(jsonObject);

                        writer.println(jsonObject);
                        writer.flush();
                        testNum=0;
                    }

                    if(socketCloseNumber==1)
                    {
                        writer.println(name + " 종료합니다.");
                        writer.flush();
                        socketCloseNumber2=1;
                        break;
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
            
//            System.out.println("AsyncTask 실행중");
            try{
                Socket socket = new Socket("10.0.2.2", 7777);
                ReceiverThread thread1 = new ReceiverThread(socket);
                SenderThread thread2 = new SenderThread(socket,name);
                thread1.start();
                thread2.start();

                while(true)
                {
                    if(socketCloseNumber2==1)
                    {
                        socket.close();
                        break;
                    }

                }

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }



//    -----------------------------------------------------------
    // 내비 바의 상태
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

}

