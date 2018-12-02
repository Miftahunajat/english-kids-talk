package com.squishydev.setoz.englishkidstalk.ui.battle.battleresult;

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

        Observable<User> allyUser = getDataManager().getUser(userId).toObservable();
        Observable<User> enemyUser = getDataManager().getUser(enemyId).toObservable();


        getCompositeDisposable().add(Observable.zip(
                allyUser,
                enemyUser,
                (user, user2) -> {
                    getMvpView().setBattleResultView(user,user2);
                    return null;
                }
        ).observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(object -> {

        },this::baseHandleError));
    }
}
