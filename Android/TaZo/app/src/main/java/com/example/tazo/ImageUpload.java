package com.example.tazo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ImageUpload extends AppCompatActivity {

//    private static final int REQUEST_CODE = 0;
    private ImageView imageView;
    private Button upLoadButton;
    private String img_path;
    private String img_path2;
    private String img_path3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);



        imageView = findViewById(R.id.image);
        upLoadButton = (Button) findViewById(R.id.upLoadButton);

        Intent intent_get_id = getIntent();
        final String user_id = intent_get_id.getStringExtra("userID");

        upLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @NonNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Uri uri = null;
                if(data != null)
                {
                    uri = data.getData();
                }
                if(uri != null)
                {
                    imageView.setImageURI(uri);
                    img_path = getPath(this,uri);

//                    img_path = Environment.getExternalStorageDirectory().getAbsolutePath() + img_path;
                    System.out.println("-------------------------------------------------");
                    System.out.println("image path : " + img_path);
                    goSend(img_path);
                }
            }

        }
    }

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

    private void goSend(String path)
    {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image","image.jpg",RequestBody.create(MultipartBody.FORM, new File(path)))
                .build();

        Request request = new Request.Builder()
                .url("https://tazoapp.site/post/test/image")
                .post(requestBody)
                .build();

        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e)
            {
                System.out.println("연결 실패");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                System.out.println("연결 성공");
                System.out.println(response);
            }
        });
    }


}