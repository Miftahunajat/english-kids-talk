package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem;

import com.squishydev.setoz.englishkidstalk.data.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

import java.util.List;

public interface LearningItemMvpView extends MvpView {

    void setupLearningItem(List<LearningItem> learningItems);
}
