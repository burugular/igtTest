package com.example.rao.igttest;

import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Rao on 22/11/2017.
 */

public class ApiClient {
    public static final String BASE_URL = "https://dl.dropboxusercontent.com/s/2ewt6r22zo4qwgx/";
    public static final String BASE_URL_TWO = "https://jsonplaceholder.typicode.com";
    public static Retrofit retrofit = null;
    public  static Retrofit getApiClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // <- add this
                    .build();
        }
        return retrofit;
    }
}
