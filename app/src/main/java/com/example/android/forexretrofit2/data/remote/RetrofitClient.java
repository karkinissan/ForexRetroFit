package com.example.android.forexretrofit2.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nissan on 7/2/2017.
 */

public class RetrofitClient {
    public static Retrofit retrofit = null;
    public static Retrofit getClient(String baseUrl){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
