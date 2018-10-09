package com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

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
}
