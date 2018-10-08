package com.squishydev.setoz.englishkidstalk.data.network;

import android.util.Log;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Challenge;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.data.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.data.model.User;
import com.squishydev.setoz.englishkidstalk.data.network.model.QuestionCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by miftahun on 9/21/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {

    }

    @Override
    public Single<List<LearningCategory>> getLearningCategory(Difficulty difficulty, String type) {
        List<LearningCategory> list = new ArrayList<>();
        list.add(new LearningCategory(0, "Animal", R.drawable.animal));
        list.add(new LearningCategory(1, "Number", R.drawable.number));
        list.add(new LearningCategory(2, "Vehicle", R.drawable.vehicle));

        return Single.just(list);
    }

    @Override
    public Single<List<LearningItem>> getLearningItem(int learningCategoryId) {
        List<LearningItem> list = new ArrayList<>();
        if (learningCategoryId == 1) {
            list.add(new LearningItem("Cow", R.drawable.cow, R.raw.cow));
            list.add(new LearningItem("Chicken", R.drawable.chicken, R.raw.chicken));
            list.add(new LearningItem("Dog", R.drawable.dog, R.raw.dog));
            list.add(new LearningItem("Cat", R.drawable.cat, R.raw.cat));
            list.add(new LearningItem("Duck", R.drawable.duck, R.raw.duck));
        }
        return Single.just(list);
    }

    @Override
    public Single<User> registerUser(String name,
                                     String userName,
                                     String password,
                                     int gender,
                                     int starGained,
                                     int xpGained) {
        Log.v("debug", name + userName + password);
        return Rx2AndroidNetworking.post(Endpoint.ENDPOINT_REGISTER_USERS)
                .addUrlEncodeFormBodyParameter("name", name)
                .addUrlEncodeFormBodyParameter("username", userName)
                .addUrlEncodeFormBodyParameter("password", password)
                .addUrlEncodeFormBodyParameter("gender",String.valueOf(gender))
                .addUrlEncodeFormBodyParameter("star_gained",String.valueOf(starGained))
                .addUrlEncodeFormBodyParameter("xp_gained",String.valueOf(xpGained))
                .build()
                .getObjectSingle(User.class);
    }

    @Override
    public Single<List<Challenge>> getChallenges() {
        List<Challenge> list = new ArrayList<>();
        list.add(new Challenge(0, 3, R.drawable.duck, "What animal is it", "duck"));
        list.add(new Challenge(0, 3, R.drawable.dog, "What animal is it", "dog"));
        list.add(new Challenge(0, 2, R.drawable.cow, "What animal is it", "cow"));
        list.add(new Challenge(0, 2, R.drawable.cat, "What animal is it", "cat"));
        list.add(new Challenge(0, 3, R.drawable.chicken, "What animal is it", "chicken"));
        return Single.just(list);
    }

    @Override
    public Observable<List<QuestionCategory>> getQuestionCategories() {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_QUESTION_CATEGORIES)
                .build()
                .getObjectListObservable(QuestionCategory.class);
    }

    @Override
    public Single<User> getUser(String id) {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_USER_PROFILE + id)
                .build()
                .getObjectSingle(User.class);
    }

    @Override
    public Single<User> updateUserStars(String id, String totalStars) {
        return Rx2AndroidNetworking.put(Endpoint.ENDPOINT_USER_PROFILE + id)
                .addUrlEncodeFormBodyParameter("star_gained",totalStars)
                .build()
                .getObjectSingle(User.class);
    }

}