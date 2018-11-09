package com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import java.util.Collections;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ProfilePresenter<V extends ProfileMvpView> extends BasePresenter<V>
        implements ProfileMvpPresenter<V> {

    private static final String TAG = "ProfilePresenter";

    @Inject
    public ProfilePresenter(DataManager dataManager,
                            CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
        getRankUser();
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getMyInventory();
        getProfileUser();
    }

    @Override
    public String getName() {
        return getDataManager().getPrefName();
    }

    @Override
    public void getProfileUser() {
        String id = getDataManager().getUserId();
        getCompositeDisposable().add(getDataManager().getUser(id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(user -> {
            getMvpView().updateProfile(user);
        },this::baseHandleError));
    }

    @Override
    public void getRankUser() {
        int userId = Integer.parseInt(getDataManager().getUserId());
        getCompositeDisposable().add(getDataManager().getAllUsers()
                .map(users -> {
                    Collections.sort(users,((o1, o2) -> o1.getXpGained() > o2.getXpGained() ? -1 : 1));
                    return users;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    int position = 0;
                    for (int i = 0; i < user.size(); i++) {
                        if (user.get(i).getId() == userId)
                            position = i+1;
                    }
                    getMvpView().updateRank(position);
                },this::baseHandleError));
    }

    @Override
    public void getMyInventory() {
        String id = getDataManager().getInventoryId();
        getCompositeDisposable().add(getDataManager().getInventory(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(inventory -> {
                    int type = getDataManager().getAvatarType();
                    getMvpView().setAvatarFromInventory(type, inventory);
                }, this::baseHandleError));
    }

    @Override
    public int getGender() {
        return getDataManager().getAvatarType();
    }
}
