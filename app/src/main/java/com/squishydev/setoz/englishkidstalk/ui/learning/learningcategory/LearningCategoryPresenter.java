package com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class LearningCategoryPresenter<V extends LearningCategoryMvpView> extends BasePresenter<V>
        implements LearningCategoryMvpPresenter<V> {

    private static final String TAG = "LearningCategoryPresenter";

    @Inject
    public LearningCategoryPresenter(DataManager dataManager,
                                     CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getLearningCategory(null,null);
    }

    @Override
    public void getLearningCategory(Difficulty difficulty, String type) {
        getCompositeDisposable().add(getDataManager().getLearningCategory(difficulty,type)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(learningCategories -> {
            getMvpView().setupLearningCategory(learningCategories);
        },throwable -> {

        }));
    }
}
