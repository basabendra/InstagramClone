package com.basabendra.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("OrZrCcziy1wUQUZl9jdY6iYiAOEbPBER4jY02CaV")
                // if defined
                .clientKey("gZsTp8Kfj4fhR3lMvT3tFTfvD28KeXeUM3TXUQuM")
                .server("https://parseapi.back4app.com/")
                .build()
        );


    }
}
