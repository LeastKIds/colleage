package com.example.tazo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ImageDownload extends AppCompatActivity {

    private EditText imageURL;
    private ImageView imageDownloadView;
    private Button imageSelect;
    private TextView imageTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_download);

        imageURL = (EditText) findViewById(R.id.imageURL);
        imageDownloadView = (ImageView) findViewById(R.id.ImageDownloadView);
        imageSelect = (Button) findViewById(R.id.imageSelect);
        imageTextView = (TextView) findViewById(R.id.ImageTextView);

//       여기에 URL에 주소 넣으면 됨
        String URL = imageURL.getText().toString();

        
//       버튼 눌렀을시 이미지 받아와서 이미지 뷰에 보여주기
        imageSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                여기가 핵심, ImageDownload는 보여줄 activity 이름, URL은 주소 imageDownloadView는 보여줄 이미지 뷰
                Glide.with(ImageDownload.this).load(URL).into((imageDownloadView));

            }
        });

    }
}