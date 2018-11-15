package com.squishydev.setoz.englishkidstalk.ui.learning.learningcategory;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningTopicsItem;
import com.squishydev.setoz.englishkidstalk.data.network.model.QuestionCategory;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
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
    }

    @Override
    public void getLearningTopics(int idQuestionCategories){
        getCompositeDisposable().add(getDataManager().getQuestionCategories()
                .flatMap(Observable::fromIterable)
                .filter(questionCategory -> questionCategory.getId() == idQuestionCategories)
                .map(QuestionCategory::getLearningTopics)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(learningTopicsItems -> {
                    getMvpView().setupTopicsItem(learningTopicsItems);
                }, this::baseHandleError));
    }
}
