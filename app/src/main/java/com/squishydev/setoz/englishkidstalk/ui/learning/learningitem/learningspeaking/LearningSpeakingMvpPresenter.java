package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking;

import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface LearningSpeakingMvpPresenter<V extends LearningSpeakingMvpView> extends MvpPresenter<V> {

    void getLearningSpeakingItem(int learningTopicId);
}

