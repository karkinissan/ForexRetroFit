package com.example.android.forexretrofit2;

import com.example.android.forexretrofit2.data.remote.ForexService;
import com.example.android.forexretrofit2.data.remote.RetrofitClient;

/**
 * Created by Nissan on 7/2/2017.
 */

public class ApiUtils {
    public static final String BASE_URL = "http://10.13.209.28/";
    public static ForexService getForexService(){
        return RetrofitClient.getClient(BASE_URL).create(ForexService.class);
    }

}
