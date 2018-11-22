package com.squishydev.setoz.englishkidstalk.data.network;

import com.squishydev.setoz.englishkidstalk.data.network.model.Challenge;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.data.network.model.Inventory;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.data.network.model.ItemCategory;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.data.network.model.QuestionCategory;
import com.squishydev.setoz.englishkidstalk.data.network.model.TokenResponse;
import com.squishydev.setoz.englishkidstalk.data.network.model.UserResponse;

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

    Observable<List<LearningItem>> getLearningItem();

    Single<UserResponse> registerUser(String name,
                                      String userName,
                                      String password,
                                      int gender,
                                      int starGained,
                                      int xpGained);

    Single<TokenResponse> loginUser(String userName,
                                    String password);

    Observable<List<Challenge>>  getChallenges();

    Observable<List<QuestionCategory>> getQuestionCategories();

    Single<User> getUser(String id);

    Single<User> updateUserStars(User user);

    Observable<Inventory> getInventory(String userId);

    Observable<Inventory> activateItemInventory(String inventoryId, String itemId);
    Observable<Inventory> deactivateItemInventory(String inventoryId, String itemId);

    Single<List<ItemCategory>> getItemCategory();

    Observable<List<Item>> getAllItem();

    Observable<List<User>> getAllUsers();

    Observable<User> addItemToInventory(String inventoryId, String itemId);
}