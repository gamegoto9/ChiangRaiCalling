package com.devdrunk.chiangraicalling;

import android.app.Application;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by CRRU0001 on 31/05/2559.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Initialize thing(s) here
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
