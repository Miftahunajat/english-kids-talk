package com.squishydev.setoz.englishkidstalk.ui.dashboard.itemstoremenu;

import android.util.Log;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.network.model.Item;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ItemStorePresenter<V extends ItemStoreMvpView> extends BasePresenter<V>
        implements ItemStoreMvpPresenter<V> {

    private static final String TAG = "ItemStorePresenter";

    @Inject
    public ItemStorePresenter(DataManager dataManager,
                              CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getAllItem() {
        Log.d(TAG, "getALlITEM");
        int gender = getDataManager().getAvatarType();
        getCompositeDisposable().add(getDataManager().getAllItem()
                .flatMap(Observable::fromIterable)
                .filter(item -> item.getGender() == gender)
                .toList()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(items -> getMvpView().setupItem(items),this::baseHandleError));
    }

    @Override
    public void getItemPercategories(int categoryId) {

    }

    @Override
    public void getUser() {
        String userId = getDataManager().getUserId();
        Log.d(TAG, "getUser: ");
        getCompositeDisposable().add(getDataManager().getUser(userId)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(
                user -> {
                    getMvpView().setUser(user);
                },this::baseHandleError
        ));
    }

    @Override
    public void buyItem(Item item) {
        String userId = getDataManager().getUserId();
        String inventoryId = getDataManager().getInventoryId();
        Log.d(TAG, "BuyItem: ");
        int star = item.getStar();
        Observable<User> updateStarUser = getDataManager().getUser(userId).flatMap(user -> {
            int userStar = user.getStarGained();
            if (userStar < star)
                throw new IllegalAccessException("Tidak cukup bintang");
            userStar -= star;
            user.setStarGained(userStar);
            return getDataManager().updateUserStars(user);
        }).toObservable();

        Observable<User> addItem = getDataManager().addItemToInventory(inventoryId, String.valueOf(item.getId()));

        getCompositeDisposable().add(Observable.concat(updateStarUser,addItem)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        user -> {
                            getUser();
                        },this::baseHandleError
                ));
    }
}
