package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

public class SubActivity extends AppCompatActivity {

    private String strNick, strProfileImg, strEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent=getIntent();
        strNick=intent.getStringExtra("name");
        strEmail=intent.getStringExtra("email");
        strProfileImg=intent.getStringExtra("profileImg");

        TextView tv_nick=findViewById(R.id.tv_nickName);
        TextView tv_email=findViewById(R.id.tv_email);
        ImageView iv_profile=findViewById(R.id.iv_profile);

        // 닉네임 set
        tv_nick.setText(strNick);
        // email set
//        Log.e("email",strEmail);
        tv_email.setText(strEmail);

        // 프로필 이미지 사진 set
        Glide.with(this).load(strProfileImg).into(iv_profile);

        findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onCompleteLogout() {
                        // 로그아웃 성공시 수행하는 지점
                        finish(); // 현재 엑티비티 종료
                    }
                });
            }
        });
    }
}