package com.example.vnnht.musicplayer;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String CHANEL_ID =  "TEXT" ;

    @Override
    public void onCreate() {
        super.onCreate();

        createNotification();
    }

    private void createNotification() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChanel = new NotificationChannel(
                    CHANEL_ID, "TEST", NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChanel);
        }
    }
}
