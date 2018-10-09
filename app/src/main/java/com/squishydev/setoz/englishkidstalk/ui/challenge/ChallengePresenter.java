package com.squishydev.setoz.englishkidstalk.ui.challenge;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ChallengePresenter<V extends ChallengeMvpView> extends BasePresenter<V>
        implements ChallengeMvpPresenter<V> {

    private static final String TAG = "ChallengePresenter";

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getAllChalleges();
    }

    @Inject
    public ChallengePresenter(DataManager dataManager,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getAllChalleges() {
        getCompositeDisposable().add(getDataManager().getChallenges()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(challenges -> {
            getMvpView().setupChallenges(challenges);
        }, this::baseHandleError));
    }

    @Override
    public void updateUserStar(int totalStars) {
        String id = getDataManager().getUserId();
        getCompositeDisposable().add(getDataManager().getUser(id)
        .flatMap(user -> getDataManager().updateUserStars(id,String.valueOf(user.getStarGained() + totalStars)))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
                user -> {

                },this::baseHandleError
        ));
    }
}
