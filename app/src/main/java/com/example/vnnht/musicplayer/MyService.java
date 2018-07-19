package com.example.vnnht.musicplayer;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import static com.example.vnnht.musicplayer.App.CHANEL_ID;

public class MyService extends Service {
    private MediaPlayer mPlayer;

    public MyService() {

    }


    public void play(){
        int link = R.raw.seven_year;
        mPlayer = MediaPlayer.create(this, link );
        mPlayer.setLooping(true);
        mPlayer.start();
    }








    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int link = intent.getIntExtra("link", -1);

        Intent notitificationInten = new Intent(this, MyService.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0 , notitificationInten, 0);

        // tạo Foregroud service
        Notification notification = new NotificationCompat.Builder(this, CHANEL_ID)
                .setContentText("service is running")
                .setContentText(link+" a").setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_archive_black_24dp)
                .setContentTitle("Seven year")
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1, notification);
        play();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        mPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
