package com.devdrunk.chiangraicalling.manager.http;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class HttpManagerPlance {

    private static HttpManagerPlance instance;

    public static HttpManagerPlance getInstance() {
        if (instance == null)
            instance = new HttpManagerPlance();
        return instance;
    }

    private Context mContext;

    private ApiServicePlance servicePlance;
    private HttpManagerPlance() {
        mContext = Contextor.getInstance().getContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.chiangraicalling.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        servicePlance = retrofit.create(ApiServicePlance.class);

    }


    public ApiServicePlance getServicePlance() {
        return servicePlance;
    }
}
