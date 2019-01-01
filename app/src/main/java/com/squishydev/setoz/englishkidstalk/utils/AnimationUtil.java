package com.squishydev.setoz.englishkidstalk.utils;

import android.graphics.Point;
import android.view.Display;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;

public class AnimationUtil {

    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    private TranslateAnimation anims[];
    int width;
    int heigth;
    private static AnimationUtil instance;

    public static AnimationUtil getInstance(BaseActivity activity){
        if (instance == null){
            instance = new AnimationUtil(activity);
        }
        return instance;
    }

    public AnimationUtil(BaseActivity activity){
        Point point = new Point();
        Display display = activity.getWindowManager().getDefaultDisplay();
        display.getSize(point);

        anims = new TranslateAnimation[] {
                new TranslateAnimation(0,0,-heigth,0),
                new TranslateAnimation(width,0,0,0),
                new TranslateAnimation(0,0,heigth,0),
                new TranslateAnimation(-width,0,0,0),
        };
        width = point.x;
        heigth = point.y;
    }

    public Animation getBounceAnimation(int time){
        TranslateAnimation anim = new TranslateAnimation(0,0,-heigth,0);
        anim.setStartOffset(time);
        anim.setInterpolator(new BounceInterpolator());

        anim.setDuration(2000);
        return anim;
    }

    public Animation getTranslationAnimation(int time, int direction){
        anims = new TranslateAnimation[] {
                new TranslateAnimation(0,0,-heigth,0),
                new TranslateAnimation(width,0,0,0),
                new TranslateAnimation(0,0,heigth,0),
                new TranslateAnimation(-width,0,0,0),
        };
        TranslateAnimation anim = anims[direction];
        anim.setStartOffset(time);

        anim.setInterpolator(new AccelerateInterpolator());
        anim.setDuration(1500);
        return anim;
    }
}
