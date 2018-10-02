package com.squishydev.setoz.englishkidstalk.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;

/**
 * Created by miftahun on 9/30/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class MediaUtils {

    public static void playSound(Context context,int resId, @Nullable MediaPlayer.OnCompletionListener listener){
        MediaPlayer mediaPlayer = MediaPlayer.create(context,resId);
        mediaPlayer.setOnCompletionListener(listener);
        mediaPlayer.start();
    }

    public static void playSound(Context context,int resId){
        MediaPlayer mediaPlayer = MediaPlayer.create(context,resId);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }
}
