package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.databinding.ActivityLearningItemBinding;
import com.squishydev.setoz.englishkidstalk.ui.base.BaseActivity;
import com.squishydev.setoz.englishkidstalk.utils.MediaUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class LearningItemActivity extends BaseActivity implements LearningItemMvpView,
        LearningItemAdapter.OnItemClick{

    @Inject
    LearningItemMvpPresenter<LearningItemMvpView> mPresenter;

    ActivityLearningItemBinding binding;
    LearningItemAdapter learningItemAdapter;
    List<LearningItem> learningItems;
    TextToSpeech tts;
    private int layouts[] = {R.drawable.latar_item_easy,R.drawable.latar_item_medium,R.drawable.latar_item_hard};
    private Difficulty mDifficulty;
    private String userId;

    public static Intent getStartIntent(Context context, int id, Difficulty mDifficulty) {
        Intent intent = new Intent(context, LearningItemActivity.class);
        intent.putExtra("id_category",id);
        intent.putExtra("difficulty",mDifficulty);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        mPresenter.onAttach(LearningItemActivity.this);

        mPresenter.getLearningItem(getIntent().getIntExtra("id_category",0));

        userId = mPresenter.getUserId();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learning_item);

        mDifficulty = (Difficulty) getIntent().getSerializableExtra("difficulty");

        binding.getRoot().setBackground(ContextCompat.getDrawable(this,layouts[mDifficulty.getNumber()]));



        learningItemAdapter = new LearningItemAdapter(this,new ArrayList<>(),this,userId);
        binding.rvLearningItem.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false));
        binding.rvLearningItem.setAdapter(learningItemAdapter);

        tts = new TextToSpeech(this, i -> {
            if(i != TextToSpeech.ERROR) {
                tts.setLanguage(Locale.UK);
            }
        });
        AudioManager am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int streamMaxVol = am.getStreamMaxVolume(am.STREAM_MUSIC);
        am.setStreamVolume(am.STREAM_MUSIC,100,0);
    }

    @Override
    public void onClick(int position) {
        tts.speak(learningItems.get(position).getLearningItemTitle(),TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void answer(String answerUser, String correctAnswer, int position) {
        if (answerUser.equals(correctAnswer)){
            MediaUtils.playSound(this,R.raw.correct);
        }
//        hideKeyboard();
        User user = new User();
        user.setId(Integer.parseInt(mPresenter.getUserId()));
        learningItemAdapter.updateLearned(position,user);
    }

    @Override
    public void onFlipSound(int position) {
        MediaUtils.playSound(this, R.raw.swap);
    }

    @Override
    public void setupLearningItem(List<LearningItem> learningItems) {
        learningItemAdapter.addAll(learningItems);
        this.learningItems = learningItems;
    }

}
