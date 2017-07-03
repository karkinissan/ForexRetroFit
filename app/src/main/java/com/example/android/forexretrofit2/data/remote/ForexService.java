package com.example.android.forexretrofit2.data.remote;

import com.example.android.forexretrofit2.data.model.ForexResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Nissan on 7/2/2017.
 */

public interface ForexService {
    @GET("/banksmart/publicResource/forex")
    Call<List<ForexResponse>> getResponse();
}
