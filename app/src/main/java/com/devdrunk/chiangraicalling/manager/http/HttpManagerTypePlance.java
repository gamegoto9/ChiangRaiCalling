package com.devdrunk.chiangraicalling.manager.http;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class HttpManagerTypePlance {

    private static HttpManagerTypePlance instance;

    public static HttpManagerTypePlance getInstance() {
        if (instance == null)
            instance = new HttpManagerTypePlance();
        return instance;
    }

    private Context mContext;
    private ApiServiceTypePlance service;

    private HttpManagerTypePlance() {
        mContext = Contextor.getInstance().getContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.chiangraicalling.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiServiceTypePlance.class);

    }
    public ApiServiceTypePlance getService(){
        return service;
    }

}