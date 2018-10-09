package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LearningItemPresenter<V extends LearningItemMvpView> extends BasePresenter<V>
        implements LearningItemMvpPresenter<V> {

    private static final String TAG = "LearningItemPresenter";



    @Inject
    public LearningItemPresenter(DataManager dataManager,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void getLearningItem(int learningCategoryId) {
        getCompositeDisposable().add(getDataManager().getLearningItem(learningCategoryId)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
                learningItems -> {
                    getMvpView().setupLearningItem(learningItems);
                },throwable -> {
                    Log.e("Error",throwable.toString());

                    if (throwable instanceof ANError) {
                        ANError anError = (ANError) throwable;
                        handleApiError(anError);
                    }
                }
        ));
    }
}
