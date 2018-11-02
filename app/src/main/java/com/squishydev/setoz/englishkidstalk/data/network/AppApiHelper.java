package com.squishydev.setoz.englishkidstalk.data.network;

import android.util.Log;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.data.network.model.Inventory;
import com.squishydev.setoz.englishkidstalk.data.network.model.ItemCategory;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.data.model.User;
import com.squishydev.setoz.englishkidstalk.data.network.model.QuestionCategory;
import com.squishydev.setoz.englishkidstalk.data.network.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

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
    public Observable<List<LearningItem>> getLearningItem() {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_LEARNING_ITEMS)
                .build()
                .getObjectListObservable(LearningItem.class);
//        List<LearningItem> list = new ArrayList<>();
//        if (learningCategoryId == 1) {
//            list.add(new LearningItem("Cow", R.drawable.cow));
//            list.add(new LearningItem("Chicken", R.drawable.chicken));
//            list.add(new LearningItem("Dog", R.drawable.dog));
//            list.add(new LearningItem("Cat", R.drawable.cat));
//            list.add(new LearningItem("Duck", R.drawable.duck));
//        }
//        return Single.just(list);
    }

    @Override
    public Single<UserResponse> registerUser(String name,
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
                .getObjectSingle(UserResponse.class);
    }

    @Override
    public Observable<List<Challenge>> getChallenges() {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_CHALLENGESS)
                .build()
                .getObjectListObservable(Challenge.class);
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
    public Single<User> updateUserStars(User user) {
        Log.d("AppAPiHelper",user.getStarGained() + "");
        return Rx2AndroidNetworking.patch(Endpoint.ENDPOINT_USER_PROFILE + user.getId())
                .addBodyParameter(user)
                .build()
                .getObjectSingle(User.class);
    }

    @Override
    public Observable<Inventory> getInventory(String userId) {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_INVETORIES + userId)
                .build()
                .getObjectObservable(Inventory.class);
    }

    @Override
    public Observable<Inventory> activateItemInventory(String inventoryId, String itemId) {
        return Rx2AndroidNetworking.post(Endpoint.ENDPOINT_ACTIVATE_ITEM)
                .addBodyParameter("inventory_id",inventoryId)
                .addBodyParameter("item_id",itemId)
                .addBodyParameter("is_active","true")
                .build()
                .getObjectObservable(Inventory.class);
    }

    @Override
    public Observable<Inventory> deactivateItemInventory(String inventoryId, String itemId) {
        return Rx2AndroidNetworking.post(Endpoint.ENDPOINT_ACTIVATE_ITEM)
                .addBodyParameter("inventory_id",inventoryId)
                .addBodyParameter("item_id",itemId)
                .addBodyParameter("is_active","false")
                .build()
                .getObjectObservable(Inventory.class);
    }

    @Override
    public Single<List<ItemCategory>> getItemCategory() {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_ITEM_CATEGORIES)
                .build()
                .getObjectListSingle(ItemCategory.class);
    }

}