package com.example.rao.igttest.Network;

import com.example.rao.igttest.App.Constants;

import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Rao on 22/11/2017.
 */

public class ApiClient {
    public static Retrofit retrofit = null;
    public  static Retrofit getApiClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // <- add this
                    .build();
        }
        return retrofit;
    }
}
