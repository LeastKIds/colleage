//package com.example.background;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Build;
//import android.util.Log;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class MyAutoRunApp extends BroadcastReceiver {
//    @Override
//    public void onReceive(Context context, Intent intent) {
//
//        Log.d("Boot","MyAutoRujkl");
//        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
//        {
//            Log.d("Boot","MyAutoRunApp.onReceive");
//
//            Intent it = new Intent(context,rebootIntent.class);
//            Log.d("Boot","Intent setting");
//            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            Log.d("Boot","addFlags");
////            context.startActivity(it);
//            Log.d("BootReceiver","Service loaded at start..");
//
//            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
//            {
//                context.startForegroundService(it);
//                Log.d("Boot","MyAutoRunApp.onReceive.if");
//            }
//            else
//            {
//                context.startService(it);
//                Log.d("Boot","MyAutoRunApp.onReceive.else");
//            }
//
//
//        }
//    }
//}
