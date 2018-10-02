package com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory;

import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

import java.util.List;

public interface LearningCategoryMvpView extends MvpView {

    void setupLearningCategory(List<LearningCategory> learningCategories);
}
