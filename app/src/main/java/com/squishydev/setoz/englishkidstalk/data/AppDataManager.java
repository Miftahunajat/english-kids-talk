package com.squishydev.setoz.englishkidstalk.data;

import android.content.Context;

import com.squishydev.setoz.englishkidstalk.data.db.DbHelper;
import com.squishydev.setoz.englishkidstalk.data.model.Challenge;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.data.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.data.model.User;
import com.squishydev.setoz.englishkidstalk.data.network.ApiHelper;
import com.squishydev.setoz.englishkidstalk.data.network.model.QuestionCategory;
import com.squishydev.setoz.englishkidstalk.data.prefs.PreferencesHelper;
import com.squishydev.setoz.englishkidstalk.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by miftahun on 9/20/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public Single<List<LearningCategory>> getLearningCategory(Difficulty difficulty, String type) {
        return mApiHelper.getLearningCategory(difficulty,type);
    }

    @Override
    public Single<List<LearningItem>> getLearningItem(int learningCategoryId) {
        return mApiHelper.getLearningItem(learningCategoryId);
    }

    @Override
    public Single<User> registerUser(String name,
                                     String userName,
                                     String password,
                                     int gender,
                                     int starGained,
                                     int xpGained) {
        return mApiHelper.registerUser(name, userName, password, gender,starGained, xpGained);
    }

    @Override
    public Single<List<Challenge>> getChallenges() {
        return mApiHelper.getChallenges();
    }

    @Override
    public Observable<List<QuestionCategory>> getQuestionCategories() {
        return mApiHelper.getQuestionCategories();
    }

    @Override
    public Single<User> getUser(String id) {
        return mApiHelper.getUser(id);
    }

    @Override
    public Single<User> updateUserStars(String id, String totalStars) {
        return mApiHelper.updateUserStars(id,totalStars);
    }

    @Override
    public void setPrefName(String name) {
        mPreferencesHelper.setPrefName(name);
    }

    @Override
    public String getPrefName() {
        return mPreferencesHelper.getPrefName();
    }

    @Override
    public void setAvatarType(int type) {
        mPreferencesHelper.setAvatarType(type);
    }

    @Override
    public int getAvatarType() {
        return mPreferencesHelper.getAvatarType();
    }

    @Override
    public void setLoggedInMode(LoggedInMode loggedInMode) {
        mPreferencesHelper.setLoggedInMode(loggedInMode);
    }

    @Override
    public int getLoggedInMode() {
        return mPreferencesHelper.getLoggedInMode();
    }

    @Override
    public void setUserId(String id) {
        mPreferencesHelper.setUserId(id);
    }

    @Override
    public String getUserId() {
        return mPreferencesHelper.getUserId();
    }
}
