package com.squishydev.setoz.englishkidstalk.ui.battle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.firebase.model.Match;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BattlePresenter<V extends BattleMvpView> extends BasePresenter<V>
        implements BattleMvpPresenter<V> {

    private static final String TAG = "BattlePresenter";
    private String MATCHES_ID = "";
    private String ENEMY_ID = "";

    @Inject
    public BattlePresenter(DataManager dataManager,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void postMatchOnline() {
        String userId = getDataManager().getUserId();

        DatabaseReference.CompletionListener callback = (databaseError, databaseReference) -> {
            if (databaseError != null) {
                getMvpView().addLog("Firebase " + databaseError.getMessage());
            }
        };
        getCompositeDisposable().add(getDataManager().postMatch(userId, callback)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(match -> {
            if (match.isPlaying()) {
                getMvpView().addLog("Someone HAs Joined");
                ENEMY_ID = match.getClientId();
                MATCHES_ID = "match_" + match.getHostId();
                observeScore();
            }
        },throwable -> {
            getMvpView().addLog(throwable.getMessage());
        }));
    }

    @Override
    public void joinRandomMatch() {
        String userId = getDataManager().getUserId();

        getCompositeDisposable().add(getDataManager().joinRandomMatch(userId)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(matches -> {
            if (matches != null && matches.size() != 0){
                getMvpView().addLog("Ada match kosong dengan musuh " + matches.get(0).getHostId());
                MATCHES_ID = "match_" + matches.get(0).getHostId();
                ENEMY_ID = matches.get(0).getHostId();
            }else {
                getMvpView().addLog("ROom Penuh");
            }
        },throwable -> {
            getMvpView().showMessage("Error firebase" + throwable.getMessage());
        }));
    }

    @Override
    public void joinMatch() {
        String userId = getDataManager().getUserId();

        getCompositeDisposable().add(getDataManager().joinMatch(userId,MATCHES_ID)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(()->{
            getMvpView().addLog("anda berhasil masuk dengan sempurna");
            observeScore();
        },throwable -> {
            getMvpView().addLog(throwable.getMessage());
        }));
    }

    @Override
    public void observeScore() {
        String userId = getDataManager().getUserId();
        getCompositeDisposable().add(getDataManager().observeScore(MATCHES_ID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(match -> {
                    Log.d("Autis",match.toString());
                    getMvpView().addMyScore(match.getScore().get(userId));
                    getMvpView().addEnemyScore(match.getScore().get(ENEMY_ID));
                    getMvpView().addLog("ketambahan sesuatu");match.getScore().get(match.getHostId());
                },throwable -> {
                    getMvpView().addLog(throwable.getMessage());
                }));
    }

    @Override
    public void addMyScore(Integer score) {
        String userId = getDataManager().getUserId();
        getCompositeDisposable().add(getDataManager().addScore(userId,MATCHES_ID,score)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(() -> {

//                    getMvpView().addMyScore(match.get(userId));
//                    getMvpView().addEnemyScore(match.get(ENEMY_ID));
//                    getMvpView().addLog("ketambahan sesuatu");
                },throwable -> {
                    getMvpView().addLog(throwable.getMessage());
                }));
    }
}
