//package com.example.tazo;
//
//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import org.w3c.dom.Text;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.io.UnsupportedEncodingException;
//import java.net.Socket;
//import java.nio.charset.StandardCharsets;
//
//public class Test extends AppCompatActivity {
//
//    private Button send_button_test;
//    private EditText message_edit_test;
//    private TextView message_text_test;
//    String sumStr="";
//
//    SenderThread thread1;
//    ReceiverThread thread2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
//
//        send_button_test = findViewById(R.id.send_button_test);
//        message_edit_test = (EditText) findViewById(R.id.message_edit_test);
//
//        message_text_test = (TextView) findViewById(R.id.message_text_test);
//        message_text_test.setText("");
//
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    // 일단은 테스트 용으로 본인의 아이피를 입력해서 진행하겠습니다.
//                    Socket socket = new Socket("10.0.2.2", 7777);
//                    // 두번째 파라메터 로는 본인의 닉네임을 적어줍니다.
//                    thread1 = new SenderThread(socket, "아니");
//                    thread2 = new ReceiverThread(socket);
//
//
//                    thread1.start();
//                    thread2.start();
//                }
//
//                catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        // -------------------------------------------------------------------
//        // 소켓 연결
//
//
//
//
//        // -----------------------------------------------------------------------
//
//
//
////        message_text_test.setTextColor(Color.parseColor("#ffffff"));
//
//        send_button_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sumStr=message_edit_test.getText().toString();
//                System.out.println(sumStr);
//                if(sumStr.equals(null) || sumStr.trim().equals(""))
//                    return ;
//                sumStr = sumStr + "\n" + message_text_test.getText().toString();
//                message_text_test.setText(sumStr);
//                message_edit_test.setText("");
//
//                thread1.sendMessage(sumStr);
//                System.out.println(thread2.getMessage());
//
//            }
//        });
//
//
//    }
//
//    class ReceiverThread extends Thread {
//        Socket socket;
//        byte[] byteStr=null;
//
//        public ReceiverThread(Socket socket) {
//            this.socket = socket;
//        }
//
//
//        public String getMessage()
//        {
//            try {
//                // Input 상대방 내용이 나에게 들어올 때.
//                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
//                while (true) {
//                    String str = reader.readLine();
//                    if (str == null) {
//                        break;
//                    }
//                    System.out.println(str);
//                    return str;
//                }
//
//            }catch (Exception e) {
//                System.out.println(e.getMessage());
//                return "error";
//            }
//            return "error";
//
//        }
//
//        @Override
//        public void run() {
//
//            System.out.println("ReceiverThread 실행");
//
//            try {
//                // Input 상대방 내용이 나에게 들어올 때.
//                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
//                while (true) {
//                    String str = reader.readLine();
////                    if (str == null) {
////                        break;
////                    }
////                System.out.println(str);
////                    sumStr = sumStr + "\n" + str;
//                    sumStr=sumStr+ "\n" + str;
//                    System.out.println(sumStr);
//                    message_text_test.setText(sumStr);
//
//                }
//
//            }
//
//            catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//    }
//
//    /**
//     * 메시지의 발신을 담당하는 스레드 입니다.
//     */
//
//    class SenderThread extends Thread {
//        Socket socket;
//        String name;
//
//        PrintWriter writer;
//
//        public SenderThread(Socket socket, String name) {
//            this.socket = socket;
//            this.name = name;
//        }
//
//        public void sendMessage(String str)
//        {
//            writer.println(str);
//            writer.flush();
//        }
//
//        @Override
//        public void run() {
//            System.out.println("SenderThread 시작 됨");
//            try {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
//                // PrintWriter writer = new PrintWriter(socket.getOutputStream());
////            Scanner sc=new Scanner(System.in);
//
//                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
//                // OutputStreamWriter writer2=new OutputStreamWriter(socket.getOutputStream(),"utf-8");
//
//                // 제일 먼저 서버로 대화명을 송신합니다.
//                // 맨 먼저 간 값이 닉네임이 되기 때문.
//                writer.println(name);
//                writer.flush();
//                System.out.println("이름 보냇음");
//
////            while (true) {
////
////                // System.out.println("여긴>");
////                String str = reader.readLine();
////                // String str=sc.nextLine();
////                System.out.println("여기까진 됨");
//
//
//
////                if (str.equals("bye")) {
////                    break;
////                }
//
//
////                writer.println(str);
////
////                writer.flush();
//                // writer2.write(str);
//                // writer2.flush();
////            }
//
//            }
//
//            catch (Exception e) {
////            System.out.println(e.getMessage());
//                e.printStackTrace();
//            }
//
//        }
//
//    }
//}
//
