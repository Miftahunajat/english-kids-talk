package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting;

import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface LearningWritingMvpPresenter<V extends LearningWritingMvpView> extends MvpPresenter<V> {

    void getLearningWritingItem(int learningTopicId);
}

