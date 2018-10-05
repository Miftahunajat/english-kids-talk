package com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory;

import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface LearningCategoryMvpPresenter<V extends LearningCategoryMvpView> extends MvpPresenter<V> {

    void getLearningCategory(Difficulty difficulty, String type);

}

