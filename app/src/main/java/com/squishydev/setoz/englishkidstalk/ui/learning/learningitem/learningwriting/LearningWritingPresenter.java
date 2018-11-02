package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LearningWritingPresenter<V extends LearningWritingMvpView> extends BasePresenter<V>
        implements LearningWritingMvpPresenter<V> {

    private static final String TAG = "LearningWritingPresenter";

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Inject
    public LearningWritingPresenter(DataManager dataManager,
                                    CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getLearningWritingItem(int learningTopicId) {
        getCompositeDisposable().add(getDataManager().getLearningItem()
                .flatMap(Observable::fromIterable)
                .filter(learningItem -> learningItem.getLearningTopic().getId() == learningTopicId)
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        learningItems -> getMvpView().setupLearningItem(learningItems),
                        this::baseHandleError
                ));
    }
}
