package com.squishydev.setoz.englishkidstalk.ui.battle.battlematch;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.firebase.model.Match;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;


import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BattleMatchPresenter<V extends BattleMatchMvpView> extends BasePresenter<V>
        implements BattleMatchMvpPresenter<V> {

    private static final String TAG = "BattleMatchPresenter";
    private String userId = null;
    int checked = 0;
    private Match match;
    private String MATCH_ID;
    private ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            String myUser = "";
            String enemyId = "";
            int myScore = 0;
            int enemyScore = 0;
            for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()){
                Log.d(TAG, "onChildChanged: @"  + messageSnapshot.getKey() + "|" + messageSnapshot.getValue());
                if (messageSnapshot.getKey().equals(getUserId())){
                    getMvpView().updateScoreMyScore(String.valueOf(messageSnapshot.getValue()));
                }else {
                    getMvpView().updateScoreEnemyScore(String.valueOf(messageSnapshot.getValue()));
                }
                myUser = messageSnapshot.getKey().equals(getUserId()) ? messageSnapshot.getKey() : myUser;
                enemyId = messageSnapshot.getKey().equals(getUserId()) ? messageSnapshot.getKey() : enemyId;
            }

            getMvpView().nextChallenge();

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    @Inject
    public BattleMatchPresenter(DataManager dataManager,
                                CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);

    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getAllChallengesQuestion();
        observingScoreChanges(getMvpView().getMatchId(),childEventListener);
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
        getCompositeDisposable().add(getDataManager().observeScore(matchId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(match -> {
            Match newMatch = match;
            getMvpView().showMessage("Score changes");
            String myUser = newMatch.getHostId().equals(getUserId()) ? newMatch.getHostId() : newMatch.getClientId();
            String enemyId = newMatch.getHostId().equals(getUserId()) ? newMatch.getClientId() : newMatch.getHostId();
            getMvpView().updateScore(match.getScore().get(myUser).toString(), match.getScore().get(enemyId).toString());
            getMvpView().nextChallenge();
            setUserData(myUser, enemyId);
        },this::baseHandleError));
    }

    @Override
    public void observingScoreChanges(String matchId, ChildEventListener listener) {
        MATCH_ID = matchId;
        getDataManager().observeScore(matchId,listener);
    }

    @Override
    public void onDetach() {
        FirebaseDatabase.getInstance().getReference().child("matches").child(getMvpView().getMatchId()).removeEventListener(childEventListener);
        super.onDetach();
    }

    @Override
    public void setUserData(String myUser, String enemyId) {
        if (checked > 0 )
            return;
        getMvpView().showMessage("yowes");
        checked++;
        Observable<User> allyUser = getDataManager().getUser(myUser).toObservable();
        Observable<User> enemyUser = getDataManager().getUser(enemyId).toObservable();

        getCompositeDisposable().add(Observable.zip(
                allyUser,
                enemyUser,
                (user, user2) -> {
                    getMvpView().setUser(user,user2);
                    return null;
                }
        ).observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(objec -> {

        },this::baseHandleError));

    }

    @Override
    public void updateUserScore(int i) {
        getCompositeDisposable().add(getDataManager().addScore(getUserId(),getMvpView().getMatchId(),i)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(()->{

        },this::baseHandleError));
    }

    @Override
    public void endMatchGame() {
        getCompositeDisposable().add(getDataManager().deleteMatch(MATCH_ID)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(voidTask -> {
            getMvpView().openBattleResult();
        },this::baseHandleError,() -> {

        }));
    }

    private String getUserId(){
        if (userId == null)
            userId = getDataManager().getUserId();
        return userId;
    }

}
