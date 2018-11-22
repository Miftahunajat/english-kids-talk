package com.squishydev.setoz.englishkidstalk.data.firebase;

import com.google.firebase.database.DatabaseReference;
import com.squishydev.setoz.englishkidstalk.data.firebase.model.Match;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface FirebaseHelper {

    Observable<Match> postMatch(String userId, DatabaseReference.CompletionListener listener);

    Single<List<Match>> joinRandomMatch(String userId);

    Completable joinMatch(String userId, String matchId);

    Observable<Match> observeScore(String matchId);

    Completable addScore(String userId, String matchId, Integer score);
}
