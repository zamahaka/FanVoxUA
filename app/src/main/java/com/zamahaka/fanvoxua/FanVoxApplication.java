package com.zamahaka.fanvoxua;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDexApplication;

import com.zamahaka.fanvoxua.model.Model;

/**
 * Created by Ura on 30.09.2016.
 */

public class FanVoxApplication extends MultiDexApplication {


    private static Context sharedContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedContext = this;
        Model.initialize(sharedContext);
    }

    @NonNull
    public static Context getSharedContext() {
        if (sharedContext == null) {
            throw new IllegalStateException(
                    "getSharedContext() called before Application.onCreate()");
        }
        return sharedContext;
    }

}
