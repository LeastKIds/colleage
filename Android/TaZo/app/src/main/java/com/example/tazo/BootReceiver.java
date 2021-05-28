package com.example.tazo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {


        Log.d("Boot","BootReceierafafda");
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            Log.d("Boot","BootReceier.onReceive");

            Intent it = new Intent(context,SocketService.class);
            Log.d("Boot","Intent setting");
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.d("Boot","addFlags");
//            context.startActivity(it);
            Log.d("BootReceiver","Service loaded at start..");

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            {
                context.startForegroundService(it);
                Log.d("Boot","BootReceier.onReceive.if");
            }
            else
            {
                context.startService(it);
                Log.d("Boot","MyAutoRunApp.onReceive.else");
            }


        }
    }
}
