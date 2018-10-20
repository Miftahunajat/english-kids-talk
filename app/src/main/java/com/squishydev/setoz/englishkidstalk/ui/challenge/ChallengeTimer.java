package com.squishydev.setoz.englishkidstalk.ui.challenge;

import android.app.Activity;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.utils.MediaUtils;

/**
 * Created by miftahun on 10/5/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public class ChallengeTimer {
    private Activity mActivity;
    private Integer totalDetik = 30000;
    private TextView tvTimer;
    private View viewDecreased;
    private TimerCallback timerCallback;
    ViewGroup.LayoutParams params;
    CountDownTimer timer;
    private int width;
    MediaPlayer ticking;

    public ChallengeTimer(BaseActivity activity, View view, TimerCallback timerCallback, TextView textView){
        this.viewDecreased = view;
        this.mActivity = activity;
        this.timerCallback = timerCallback;
        this.tvTimer = textView;
        params = view.getLayoutParams();
        ticking = MediaPlayer.create(activity,R.raw.tick_tock);
        ticking.setLooping(false);
        ticking.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                ticking.start();
            }
        });
    }

    public void start(){
        ticking.start();
        timer = new CountDownTimer(totalDetik,1000){
            @Override
            public void onTick(long l) {
                Log.v("DEBUG","cok");
                updateProgress((int) l);
            }

            @Override
            public void onFinish() {
                viewDecreased.setVisibility(View.GONE);
                tvTimer.setText("0");
                timerCallback.onFinish();
                ticking.stop();
                ticking.release();
            }
        }.start();
    }

    public void stop(){
        timer.cancel();
        ticking.release();
    }

    void updateProgress(Integer detik){
        setWidthView(detik);

        tvTimer.setText(String.valueOf(detik / 1000));
    }

    Integer getWidthSize(){
        Display display = mActivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        try {
            display.getRealSize(size);
        }catch (NoSuchMethodError error){
            display.getSize(size);
        }
        return size.x;
    }



    public interface TimerCallback{
        void onFinish();
    }

    void setWidthView(Integer detik){
        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(
                (int)(detik.floatValue() / totalDetik.floatValue() * (float) params.width),
                (int)(params.height));
        lp.leftMargin = (int) (48f * mActivity.getResources().getDisplayMetrics().density);
        lp.bottomToBottom = R.id.loading_empty;
        lp.leftToLeft= R.id.loading_empty;
        lp.topToTop = R.id.loading_empty;

        viewDecreased.setLayoutParams(lp);
    }
}
