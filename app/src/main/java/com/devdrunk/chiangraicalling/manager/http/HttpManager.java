package com.devdrunk.chiangraicalling.manager.http;

import android.content.Context;

import com.google.gson.Gson;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class HttpManager {

    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null)
            instance = new HttpManager();
        return instance;
    }

    private Context mContext;
    private ApiService service;
    private HttpManager() {
        mContext = Contextor.getInstance().getContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.chiangraicalling.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);

    }
    public ApiService getService(){
        return service;
    }

}