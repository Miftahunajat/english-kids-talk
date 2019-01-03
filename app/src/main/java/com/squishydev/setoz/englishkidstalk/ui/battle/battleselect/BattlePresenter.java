package com.squishydev.setoz.englishkidstalk.ui.battle.battleselect;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.firebase.model.Match;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BattlePresenter<V extends BattleMvpView> extends BasePresenter<V>
        implements BattleMvpPresenter<V> {

    private static final String TAG = "BattlePresenter";
    private String MATCHES_ID = "";
    private String ENEMY_ID = "";
    private User myUser;

    @Inject
    public BattlePresenter(DataManager dataManager,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        String userId = getDataManager().getUserId();
        getCompositeDisposable().add(getDataManager().getUser(userId)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(user1 -> myUser = user1,this::baseHandleError));

    }

    @Override
    public void postMatchOnline() {
        String userId = getDataManager().getUserId();
        String userName = getDataManager().getPrefName();

        DatabaseReference.CompletionListener callback = (databaseError, databaseReference) -> {
            if (databaseError != null) {
                getMvpView().addLog("Firebase " + databaseError.getMessage());
            }
        };
        getCompositeDisposable().add(getDataManager().postMatch(userId,userName, callback)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(match -> {
            if (match.isPlaying() && match.getClientId() != null) {
                Log.d(TAG, "postMatchOnline: bude" + match.toString());
                ENEMY_ID = match.getClientId();
                MATCHES_ID = "match_" + match.getHostId();
                loadEnemyId(ENEMY_ID);
//                observeScore();
            }else {
                MATCHES_ID = "match_" + match.getHostId();
                getMvpView().loadJoinFragment(myUser);
            }
        },throwable -> getMvpView().addLog(throwable.getMessage())));
    }

    private void loadEnemyId(String userId) {
        Log.d(TAG, "loadEnemyId bude: " +  userId);
        getCompositeDisposable().add(getDataManager().getUser(userId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(user1 -> getMvpView().updateJoinFragment(user1), throwable -> getMvpView().showMessage(throwable.getMessage())));
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
        },throwable -> getMvpView().showMessage("Error firebase" + throwable.getMessage())));
    }

    @Override
    public void joinMatch(Match matchId) {
        String userId = getDataManager().getUserId();
        MATCHES_ID = "match_" + matchId.getHostId();
        Single<User> getUser = getDataManager().getUser(matchId.getHostId());
        getCompositeDisposable().add(getDataManager().joinMatch(userId,MATCHES_ID).subscribeOn(Schedulers.io())
                .andThen(getUser.subscribeOn(Schedulers.io()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribe(user2 -> {
            getMvpView().loadJoinFragment(myUser,user2);
            ENEMY_ID = String.valueOf(user2.getId());
            observeMatch();
        },this::baseHandleError));
    }

    @Override
    public void observeScore() {
        String userId = getDataManager().getUserId();
        getCompositeDisposable().add(getDataManager().observeScore(MATCHES_ID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(match -> {
                    Log.d("Autis",match.toString());
//                    getMvpView().addMyScore(match.getScore().get(userId));
//                    getMvpView().addEnemyScore(match.getScore().get(ENEMY_ID));
                    getMvpView().addLog("ketambahan sesuatu");
                },throwable -> getMvpView().addLog(throwable.getMessage())));
    }

    @Override
    public void addMyScore(Integer score) {
        String userId = getDataManager().getUserId();
        getCompositeDisposable().add(getDataManager().addScore(userId,MATCHES_ID,score)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(() -> {

                },throwable -> getMvpView().addLog(throwable.getMessage())));
    }

    @Override
    public void getAllMatches() {
        String userId = getDataManager().getUserId();

        Log.d(TAG, "getAllMatches: " + "Sebelum");
        getCompositeDisposable().add(getDataManager().joinRandomMatch(userId)
                .flatMap(matches -> Flowable.fromIterable(matches).filter(match -> !match.isPlaying()).toList().toFlowable())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(matches -> {
                    if (matches != null && matches.size() != 0){
                        getMvpView().updateMatch(matches);
                    }else {
                        getMvpView().updateMatch(matches);
                    }
                },throwable -> {
                    getMvpView().showMessage("Error firebase" + throwable.getMessage());
                }));
    }


    @Override
    public void deleteMatch() {
        getCompositeDisposable().add(getDataManager().deleteMatch(MATCHES_ID)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe());
    }

    @Override
    public void startMatch() {
        getCompositeDisposable().add(getDataManager().startMatch(MATCHES_ID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(()-> getMvpView().loadBattleMatchActivity(MATCHES_ID,String.valueOf(myUser.getId()),ENEMY_ID)));
    }

    public void observeMatch(){
        getCompositeDisposable().add(getDataManager().observeMatch(MATCHES_ID)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(match -> {
            if (match.isStarting()) {
                getMvpView().loadBattleMatchActivity(MATCHES_ID, String.valueOf(myUser.getId()), ENEMY_ID);
            }
        },this::baseHandleError));
    }
}
