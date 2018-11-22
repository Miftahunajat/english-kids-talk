package com.squishydev.setoz.englishkidstalk.data.firebase;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squishydev.setoz.englishkidstalk.data.firebase.model.Match;
import com.squishydev.setoz.englishkidstalk.di.ApplicationContext;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import durdinapps.rxfirebase2.DataSnapshotMapper;
import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class AppFirebaseHelper implements FirebaseHelper {

    FirebaseDatabase firebaseDatabase;

    @Inject
    public AppFirebaseHelper(@ApplicationContext Context context) {
        firebaseDatabase = FirebaseDatabase.getInstance();
    }


    @Override
    public Observable<Match> postMatch(String userId, DatabaseReference.CompletionListener listener) {
        DatabaseReference matchReference = firebaseDatabase.getReference().child("matches");
        Match match = new Match();
        match.setPlaying(false);
        match.setScore(new HashMap<>());
        match.setHostId(userId);
        HashMap<String,Object> matchHashMap = new HashMap<>();
        matchHashMap.put("match_"+userId,match);
        matchReference.updateChildren(matchHashMap,listener);
        return RxFirebaseDatabase.observeValueEvent(matchReference.child("match_"+userId),Match.class).toObservable();
    }

    @Override
    public Single<List<Match>> joinRandomMatch(String userId) {
        DatabaseReference matchReference = firebaseDatabase.getReference().child("matches");
        return RxFirebaseDatabase.observeSingleValueEvent(matchReference,DataSnapshotMapper.listOf(Match.class)).toObservable()
                .flatMap(Observable::fromIterable)
                .filter(match -> !match.isPlaying())
                .toList().toObservable()
                .firstOrError();
    }

    @Override
    public Completable joinMatch(String userId, String matchId) {
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("matches").child(matchId);

        databaseReference.child("playing").setValue(true);
        return RxFirebaseDatabase.observeSingleValueEvent(databaseReference,Match.class)
                .flatMapCompletable(match -> {
                    match.setClientId(userId);
                    match.setPlaying(true);
                    HashMap<String,Integer> score = new HashMap<>();
                    score.put(userId,0);
                    score.put(match.getHostId(),0);
                    match.setScore(score);
                    return RxFirebaseDatabase.setValue(databaseReference,match);
                });
    }

    @Override
    public Observable<Match> observeScore(String matchId) {
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("matches").child(matchId);
        return RxFirebaseDatabase.observeValueEvent(databaseReference,Match.class).toObservable() ;
    }


    @Override
    public Completable addScore(String userId, String matchId, Integer score) {
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("matches").child(matchId).child("score");
        return RxFirebaseDatabase.observeSingleValueEvent(databaseReference,DataSnapshotMapper.mapOf(Integer.class))
        .flatMapCompletable(map -> {
            Integer k= map.get(userId) + score;
            return RxFirebaseDatabase.setValue(databaseReference.child(userId),k);
        });
    }

}
