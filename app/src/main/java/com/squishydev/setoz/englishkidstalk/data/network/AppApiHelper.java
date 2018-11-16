package com.squishydev.setoz.englishkidstalk.data.network;

import android.util.Log;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.data.network.model.Inventory;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.data.network.model.ItemCategory;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.data.network.model.QuestionCategory;
import com.squishydev.setoz.englishkidstalk.data.network.model.TokenResponse;
import com.squishydev.setoz.englishkidstalk.data.network.model.UserResponse;
import com.squishydev.setoz.englishkidstalk.data.prefs.PreferencesHelper;

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

    private Map<String,String> mHeader;

    @Inject
    PreferencesHelper preferencesHelper;

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
                .addHeaders(getHeader())
                .build()
                .getObjectListObservable(LearningItem.class);
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
    public Single<TokenResponse> loginUser(String userName, String password) {
        return Rx2AndroidNetworking.post(Endpoint.ENDPOINT_LOGIN_USERS)
                .addUrlEncodeFormBodyParameter("username", userName)
                .addUrlEncodeFormBodyParameter("password", password)
                .build()
                .getObjectSingle(TokenResponse.class);
    }

    @Override
    public Observable<List<Challenge>> getChallenges() {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_CHALLENGESS)
                .addHeaders(getHeader())
                .build()
                .getObjectListObservable(Challenge.class);
    }

    @Override
    public Observable<List<QuestionCategory>> getQuestionCategories() {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_QUESTION_CATEGORIES)
                .addHeaders(getHeader())
                .build()
                .getObjectListObservable(QuestionCategory.class);
    }

    @Override
    public Single<User> getUser(String id) {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_USER_PROFILE + "/" + id)
                .addHeaders(getHeader())
                 .build()
                .getObjectSingle(User.class);
    }

    @Override
    public Single<User> updateUserStars(User user) {
        Log.d("AppAPiHelper",user.getStarGained() + "");
        return Rx2AndroidNetworking.patch(Endpoint.ENDPOINT_USER_PROFILE + "/" + user.getId())
                .addHeaders(getHeader())
                .addBodyParameter("star_gained", String.valueOf(user.getStarGained()))
                .build()
                .getObjectSingle(User.class);
    }

    @Override
    public Observable<Inventory> getInventory(String userId) {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_INVETORIES + userId)
                .addHeaders(getHeader())
                .build()
                .getObjectObservable(Inventory.class);
    }

    @Override
    public Observable<Inventory> activateItemInventory(String inventoryId, String itemId) {
        return Rx2AndroidNetworking.post(Endpoint.ENDPOINT_ACTIVATE_ITEM)
                .addHeaders(getHeader())
                .addBodyParameter("inventory_id",inventoryId)
                .addBodyParameter("item_id",itemId)
                .addBodyParameter("is_active","true")
                .build()
                .getObjectObservable(Inventory.class);
    }

    @Override
    public Observable<Inventory> deactivateItemInventory(String inventoryId, String itemId) {
        return Rx2AndroidNetworking.post(Endpoint.ENDPOINT_ACTIVATE_ITEM)
                .addHeaders(getHeader())
                .addBodyParameter("inventory_id",inventoryId)
                .addBodyParameter("item_id",itemId)
                .addBodyParameter("is_active","false")
                .build()
                .getObjectObservable(Inventory.class);
    }

    @Override
    public Single<List<ItemCategory>> getItemCategory() {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_ITEM_CATEGORIES)
                .addHeaders(getHeader())
                .build()
                .getObjectListSingle(ItemCategory.class);
    }

    @Override
    public Observable<List<Item>> getAllItem() {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_GET_ITEMS)
                .addHeaders(getHeader())
                .build()
                .getObjectListObservable(Item.class);
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return Rx2AndroidNetworking.get(Endpoint.ENDPOINT_USER_PROFILE)
                .addHeaders(getHeader())
                .build()
                .getObjectListObservable(User.class);
    }

    @Override
    public Observable<User> addItemToInventory(String inventoryId, String itemId) {
        return Rx2AndroidNetworking.post(Endpoint.ENDPOINT_ADD_ITEM_TO_INVENTORIES)
                .addHeaders(getHeader())
                .addBodyParameter("inventory_id",inventoryId)
                .addBodyParameter("item_id",itemId)
                .build()
                .getObjectObservable(User.class);
    }

    private Map<String,String> getHeader(){
        if (mHeader == null){
            mHeader = new HashMap<>();
            mHeader.put("Authorization","Bearer " + preferencesHelper.getToken());
        }
        return mHeader;
    }

}