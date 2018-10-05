package com.squishydev.setoz.englishkidstalk.data.network;

import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.data.model.LearningItem;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by miftahun on 9/21/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public interface ApiHelper {
    Single<List<LearningCategory>> getLearningCategory(Difficulty difficulty, String type);

    Single<List<LearningItem>> getLearningItem(int learningCategoryId);
}