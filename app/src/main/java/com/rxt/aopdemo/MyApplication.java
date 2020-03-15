package com.rxt.aopdemo;

import android.app.Application;

/**
 * Created by raoxuting on 2020/3/15.
 */
public class MyApplication extends Application {

    private static Application myApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplicationContext = this;
    }

    public static Application getMyApplicationContext() {
        return myApplicationContext;
    }
}
