package com.zamahaka.fanvoxua.model;

import android.content.Context;

/**
 * Created by Ura on 30.09.2016.
 */

public class Model {

    private static Model instance;

    public static void initialize(Context context) {
        if (instance == null) {
            instance = new Model(context);
        }
    }

    public static Model getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Called method on uninitialized model");
        }

        return instance;
    }

    private Model(Context context) {

    }

}
