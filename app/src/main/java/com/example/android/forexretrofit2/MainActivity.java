package com.example.android.forexretrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.android.forexretrofit2.data.model.ForexResponse;
import com.example.android.forexretrofit2.data.remote.ForexService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ForexService mService;
    private ForexAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService = ApiUtils.getForexService();
        loadAnswers();

    }

    private void loadAnswers() {
        mService.getResponse().enqueue(new Callback<List<ForexResponse>>() {
            @Override
            public void onResponse(Call<List<ForexResponse>> call, Response<List<ForexResponse>> response) {
                Log.v("MainActivity", "URL: " + call.request().url());
                if (response.isSuccessful()) {
                    mAdapter = new ForexAdapter(MainActivity.this, response.body());
                    ListView listView = (ListView) findViewById(R.id.list_view);
                    listView.setAdapter(mAdapter);
                } else {
                    int statusCode = response.code();
                    Log.v("MainActivity", "Status Code: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<ForexResponse>> call, Throwable t) {

                Log.v("MainActivity", "URL: " + call.request().url());
                Log.d("MainActivity", "error loading from API " + t.getMessage());
            }

        });

    }
}
