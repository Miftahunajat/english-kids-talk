package com.squishydev.setoz.englishkidstalk.data.network;

import com.squishydev.setoz.englishkidstalk.data.model.Challenge;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.data.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.data.model.User;
import com.squishydev.setoz.englishkidstalk.data.network.model.QuestionCategory;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by miftahun on 9/21/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public interface ApiHelper {
    Single<List<LearningCategory>> getLearningCategory(Difficulty difficulty, String type);

    Single<List<LearningItem>> getLearningItem(int learningCategoryId);

    Single<User> registerUser(String name,
                              String userName,
                              String password,
                              int gender,
                              int starGained,
                              int xpGained);

    Single<List<Challenge>>  getChallenges();

    Observable<List<QuestionCategory>> getQuestionCategories();

    Single<User> getUser(String id);

    Single<User> updateUserStars(String id, String totalStars);
}