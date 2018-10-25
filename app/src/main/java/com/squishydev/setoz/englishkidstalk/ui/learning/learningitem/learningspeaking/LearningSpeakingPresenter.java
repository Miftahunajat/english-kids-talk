package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningspeaking;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import java.util.Collections;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LearningSpeakingPresenter<V extends LearningSpeakingMvpView> extends BasePresenter<V>
        implements LearningSpeakingMvpPresenter<V> {

    private static final String TAG = "LearningSpeakingPresenter";

    @Inject
    public LearningSpeakingPresenter(DataManager dataManager,
                                     CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getLearningSpeakingItem(int learningTopicId) {
        getCompositeDisposable().add(getDataManager().getLearningItem()
                .flatMap(Observable::fromIterable)
                .filter(learningItem -> learningItem.getLearningTopic().getId() == learningTopicId)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(learningItems -> {
                    getMvpView().setupLearningItem(learningItems);

                },this::baseHandleError));

    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getLearningSpeakingItem(58);
    }
}