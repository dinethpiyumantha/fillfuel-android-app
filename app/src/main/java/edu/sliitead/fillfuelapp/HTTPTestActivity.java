package edu.sliitead.fillfuelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HTTPTestActivity extends AppCompatActivity {

    private TextView txtResultHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httptest);

        txtResultHttp = (TextView) findViewById(R.id.txtTestResultHttp);

        OkHttpClient client = new OkHttpClient();
        String url = "https://fillfuel-backend-service.vercel.app/api/fuel";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()) {
                    String myResponse = response.body().string();

                    HTTPTestActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txtResultHttp.setText(myResponse);
                        }
                    });
                }
            }
        });
    }
}