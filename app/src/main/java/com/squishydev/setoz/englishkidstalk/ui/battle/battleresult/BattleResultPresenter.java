package com.squishydev.setoz.englishkidstalk.ui.battle.battleresult;

import android.util.Log;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BattleResultPresenter<V extends BattleResultMvpView> extends BasePresenter<V>
        implements BattleResultMvpPresenter<V> {

    private static final String TAG = "BattleResultPresenter";

    @Inject
    public BattleResultPresenter(DataManager dataManager,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getUserData(String userId, String enemyId) {

        Single<User> enemyUser = getDataManager().getUser(enemyId);
        String myName = getDataManager().getPrefName();


        getCompositeDisposable().add(enemyUser
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(user -> {
            getMvpView().setBattleResultView(myName,user.getName());
        },this::baseHandleError));
    }
}
