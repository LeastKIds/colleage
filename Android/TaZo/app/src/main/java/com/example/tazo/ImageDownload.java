package com.example.tazo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageDownload extends AppCompatActivity {

    private EditText imageURL;
    private ImageView imageDownloadView;
    private Button imageSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_download);

        imageURL = (EditText) findViewById(R.id.imageURL);
        imageDownloadView = (ImageView) findViewById(R.id.ImageDownloadView);
        imageSelect = (Button) findViewById(R.id.imageSelect);

        String URL = imageURL.getText().toString();

        imageSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(ImageDownload.this).load(URL).into(imageDownloadView);
            }
        });

    }
}