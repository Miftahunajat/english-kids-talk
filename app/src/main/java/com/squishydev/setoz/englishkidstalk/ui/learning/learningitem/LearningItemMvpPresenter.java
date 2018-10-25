package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem;

import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface LearningItemMvpPresenter<V extends LearningItemMvpView> extends MvpPresenter<V> {

    void getLearningItem(int learningCategoryId);
}

