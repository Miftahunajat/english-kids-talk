package com.squishydev.setoz.englishkidstalk.ui.challenge;

import android.util.Log;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import java.util.Collections;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ChallengePresenter<V extends ChallengeMvpView> extends BasePresenter<V>
        implements ChallengeMvpPresenter<V> {

    private static final String TAG = "ChallengePresenter";

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Inject
    public ChallengePresenter(DataManager dataManager,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getAllChalleges(Difficulty difficulty) {
        Log.v(TAG, "getAllChalleges: " + difficulty.getText());
        getCompositeDisposable().add(getDataManager().getChallenges()
                .flatMap(Observable::fromIterable)
                .filter(challenge -> challenge.getQuestionCategory().getQuestionDifficultyId() == difficulty.getId())
                .filter(challenge -> challenge.getChallengeType() <= difficulty.getId() + 1)
                .toList()
                .map(challenges -> {
                    Collections.shuffle(challenges);
                    return challenges;
                })
                .map(challenges -> challenges.subList(0,5))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(challenges -> {
                    Log.d(TAG, "getAllChalleges: " + challenges.size() + "juga");
                    getMvpView().setupChallenges(challenges);
                    }, this::baseHandleError));
    }

    @Override
    public void updateUserStar(int totalStars) {
        String id = getDataManager().getUserId();
        getCompositeDisposable().add(getDataManager().getUser(id)
        .flatMap(user -> {
            user.setStarGained(user.getStarGained() + totalStars);
            return getDataManager().updateUserStars(user);
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
                user -> {
                    getMvpView().finish();
                },this::baseHandleError
        ));
    }
}
