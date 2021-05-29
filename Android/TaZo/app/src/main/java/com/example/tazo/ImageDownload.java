package com.example.tazo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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


        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("nickname","Kimjinhong").build();
        Request request = new Request.Builder()
                .url("https://tazoapp.site/user/test/nickname")
                .patch(formBody)
                .build();

//                Response response = client.newCall(request).execute();
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

//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setClient(new OkClient())
//                .setEndpoint(ENDPOINT)
//                .build();
//        MyPatchService patchService = restAdapter.create(MyPatchService.class);
//        UserUpdate updatedUser = new UserUpdate();
//        updatedUser.Salutation = "Mr";
//        patchService.update(updatedUser);

















        String record ="";
        HttpAsyncTask httpAsyncTask = new HttpAsyncTask(record);
        try {
            System.out.println("error");
            record =httpAsyncTask.execute("https://tazoapp.site/users/test").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(record);

    }

    private static class HttpAsyncTask extends AsyncTask<String, Void, String> {

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


}