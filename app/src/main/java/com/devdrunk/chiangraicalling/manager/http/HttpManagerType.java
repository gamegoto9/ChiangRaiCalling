package com.devdrunk.chiangraicalling.manager.http;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class HttpManagerType {

    private static HttpManagerType instance;

    public static HttpManagerType getInstance() {
        if (instance == null)
            instance = new HttpManagerType();
        return instance;
    }

    private Context mContext;
    private ApiServiceType service;

    private HttpManagerType() {
        mContext = Contextor.getInstance().getContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.chiangraicalling.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiServiceType.class);


    }
    public ApiServiceType getService(){
        return service;
    }


}
