package com.readsms;

import android.app.Application;

/**
 * Created by altaf.h.shaikh on 1/6/2017.
 */

public class ReadSMSApp extends Application {

    private static ReadSMSApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static ReadSMSApp getInstance() {
        return instance;
    }
}
