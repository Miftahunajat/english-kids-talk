package com.squishydev.setoz.englishkidstalk.ui.battle.battlematch;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BattleMatchPresenter<V extends BattleMatchMvpView> extends BasePresenter<V>
        implements BattleMatchMvpPresenter<V> {

    private static final String TAG = "BattleMatchPresenter";
    private String userId = null;

    @Inject
    public BattleMatchPresenter(DataManager dataManager,
                                CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);

    }


    @Override
    public void getAllChallengesQuestion() {
        getCompositeDisposable().add(getDataManager().getChallenges()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(challenges -> {
            getMvpView().setDataChallenges(challenges);
        },this::baseHandleError));
    }

    @Override
    public void observingScoreChanges(String matchId) {
        getCompositeDisposable().add(getDataManager().observeMatch(matchId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(match -> {
            String myUser = match.getHostId().equals(getUserId()) ? match.getHostId() : match.getClientId();
            String enemyId = match.getHostId().equals(getUserId()) ? match.getClientId() : match.getHostId();
            getMvpView().updateScore(myUser, enemyId);

        },this::baseHandleError));
    }

    private String getUserId(){
        if (userId == null)
            userId = getDataManager().getUserId();
        return userId;
    }

}
