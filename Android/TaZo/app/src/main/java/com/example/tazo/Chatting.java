package com.example.tazo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Chatting extends AppCompatActivity {
//  이미지 전송 버튼 **************************************
    private ImageButton imageButton;
    private String img_path;
//  *****************************************************

//  예전 채팅 기록 ****************************************
    private String record ="";
//  *****************************************************
//  옆에 네비게이션 바 ************************************
    private DrawerLayout drawerLayout;
    private View drawerView;
//  *****************************************************
//  채팅을 위한 소켓 **************************************
    private TextView textView_test;
    private Button socketClose;
    private int socketCloseNumber=0;
    private int socketCloseNumber2=0;

    private ArrayList<ChattingData> arrayList = new ArrayList<>();
    private ChattingAdapter chattingAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayout;

//  *****************************************************
//  메세지 전송 시 ****************************************
    private Message msg;
    static int testNum=0;
    JSONObject jsonObject;
//  *****************************************************


    private Button send_button_test;
    private EditText message_edit_test;
    String sumStr="";
    String name="닉네임1";
    String nameCheck="";
    String imgURL="";
    int inOut=-1;

    ReceiverThread thread1;

    ChattingData chatData;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

//      AsyncTask 활용해서 소켓 실행 ***************************************************
        HttpAsyncTask httpAsyncTask = new HttpAsyncTask(record);
        try {
            record =httpAsyncTask.execute("https://tazoapp.site/rooms/1/chat").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      *******************************************************************************


//      예전 채팅 기록 *****************************************************************
        setRecord(record);
//      *******************************************************************************


//  키보드가 나올 시 레이아웃 변경 **********************************************************
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//  **************************************************************************************

//      네비게이션 바 ********************************************************************
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
//      ********************************************************************************

//      상단 바 없애기 *******************************************************************
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
//      ********************************************************************************


        send_button_test = findViewById(R.id.send_button_test);
        message_edit_test = (EditText) findViewById(R.id.message_edit_test);


        ConectNet conectNet = new ConectNet(name);
        conectNet.execute();

        recyclerView = (RecyclerView) findViewById(R.id.chatting_test);
        linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);



        chattingAdapter = new ChattingAdapter(arrayList);
        recyclerView.setAdapter(chattingAdapter);

        RecyclerDecoration spaceDecoration = new RecyclerDecoration(30);
        recyclerView.addItemDecoration(spaceDecoration);

//      메세지 전송 ******************************************************************

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
//  *********************************************************************************


//        recyclerView.scrollToPosition(ChattingAdapter.getItemCount()-1);

//  뒤로 나가기 **************************************************************
        socketClose = (Button) findViewById(R.id.socketClose);
        socketClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("socket close button");
                socketCloseNumber=1;
                onBackPressed();
            }
        });
//   **********************************************************************



//  이미지전송 버튼 **********************************************************
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

//  ************************************************************************

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg){
//            System.out.println("일단 handler는 실행 됨");
            if(msg.what==1)
            {
                String messageStr=(String)msg.obj;

                chatData = new ChattingData(imgURL, nameCheck, messageStr, name, inOut);
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
                        imgURL=(String) jsonStr.get("image");
                        if(imgURL == null)
                            imgURL = "https://tazoapp.site/placeholder-profile.png";
//                        System.out.println(123123);
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

//                ---------------------------------------------------
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

    private static class HttpAsyncTask extends AsyncTask<String, Void, String>{

        OkHttpClient client = new OkHttpClient();
        String result;

        public HttpAsyncTask(String result)
        {
            this.result=result;
        }

        @Override
        protected String doInBackground(String... params) {

            String strUrl = params[0];

            try {
                Request request = new Request.Builder().url(strUrl).build();
                Response response = client.newCall(request).execute();
                result = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return result;
        }



    }

    public void setRecord(String recordMessage)
    {

        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(recordMessage);
            JSONArray jsonArray = (JSONArray) obj;

            for(int i=0; i<jsonArray.size(); i++)
            {
//                System.out.println(jsonArray.get(i));
                System.out.println("--------------------");
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String content = (String) jsonObject.get("content");
                JSONObject nameJson = (JSONObject) jsonObject.get("User");
                String recordName = (String) nameJson.get("nickname");
                String imgURLSet= (String) nameJson.get("image");
                if(imgURLSet == null)
                    imgURLSet = "https://tazoapp.site/placeholder-profile.png";
                System.out.println("nickname : " + recordName);
                System.out.println("content : " + content);
                System.out.println("imgURLSet : " + imgURLSet);

                inOut = 1;

                chatData = new ChattingData(imgURLSet, recordName, content, name, inOut);
                arrayList.add(chatData);


            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

//  이미지 경로 확인 *******************************************************************
    @Nullable
    public static String getPath(@NonNull Context context, @NonNull Uri uri)
    {
        final ContentResolver contentResolver = context.getContentResolver();

        if(contentResolver == null)
        {
            return null;
        }

        String filePath = context.getApplicationInfo().dataDir + File.separator + System.currentTimeMillis();

        File file = new File(filePath);

        try {
            InputStream inputStream = contentResolver.openInputStream(uri);
            if(inputStream == null)
                return null;

            OutputStream outputStream = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len = inputStream.read(buf)) > 0)
            {
                outputStream.write(buf,0,len);
            }

            outputStream.close();
            inputStream.close();
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }

        return file.getAbsolutePath();

    }
//  ***********************************************************************************

//  뒤로가기 / 이미지 선택 후 ************************************************************
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @NonNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1) {
//            if (resultCode == RESULT_OK) {
//                Uri uri = null;
//                if(data != null)
//                {
//                    uri = data.getData();
//                }
//                if(uri != null)
//                {
//
////                    imageView.setImageURI(uri);   // 올리자마자 채팅방으로 가는게 아니라, 서버에 갔다가 옴
//                    img_path = getPath(this,uri);
//
////                    img_path = Environment.getExternalStorageDirectory().getAbsolutePath() + img_path;
//                    System.out.println("-------------------------------------------------");
//                    System.out.println("image path : " + img_path);
//                    goSend(img_path);
//                }
//            }
//
//        }
        if(requestCode == 1)
        {
            if(data == null) {}
            else {
                if(data.getClipData() == null)  Toast.makeText(this, "다중 선택 불가능", Toast.LENGTH_SHORT).show();
                else {
                    ClipData clipData = data.getClipData();
                    Log.i("clipData",String.valueOf(clipData.getItemCount()));

                    if(clipData.getItemCount() > 5) Toast.makeText(this,"사진은 5장 까지",Toast.LENGTH_SHORT).show();
                    else if (clipData.getItemCount() == 1) {
                        img_path = getPath(this, data.getData());
                        goSend(img_path);
                    }
                    else if (clipData.getItemCount() > 1 && clipData.getItemCount() <=5) {
                        for (int i=0; i<clipData.getItemCount(); i++)
                        {
                            img_path = getPath(this, clipData.getItemAt(i).getUri());
                            System.out.println(img_path);
                        }
                    }
                }
            }
        }
    }
//  *************************************************************************************
//  사진 보내기 **************************************************************************
    private void goSend(String path)
    {
        System.out.println("보냈음 : "+path);
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("image","image.jpg",RequestBody.create(MultipartBody.FORM, new File(path)))
//                .build();
//
//        Request request = new Request.Builder()
//                .url("https://tazoapp.site/post/test/image")
//                .post(requestBody)
//                .build();
//
//        OkHttpClient client = new OkHttpClient();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e)
//            {
//                System.out.println("연결 실패");
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException
//            {
//                System.out.println("연결 성공");
//                System.out.println(response);
//            }
//        });
    }
//   ********************************************************************************

}

