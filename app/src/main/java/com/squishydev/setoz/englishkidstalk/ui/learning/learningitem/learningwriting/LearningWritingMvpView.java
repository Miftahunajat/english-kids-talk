package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting;

import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

import java.util.List;

public interface LearningWritingMvpView extends MvpView {

    void setupLearningItem(List<LearningItem> learningItems);
}
