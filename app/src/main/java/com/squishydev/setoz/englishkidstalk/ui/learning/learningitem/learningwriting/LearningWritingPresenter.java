package com.squishydev.setoz.englishkidstalk.ui.learning.learningitem.learningwriting;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.network.model.LearningItem;
import com.squishydev.setoz.englishkidstalk.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LearningWritingPresenter<V extends LearningWritingMvpView> extends BasePresenter<V>
        implements LearningWritingMvpPresenter<V> {

    private static final String TAG = "LearningWritingPresenter";

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        getLearningWritingItem(1);
    }

    @Inject
    public LearningWritingPresenter(DataManager dataManager,
                                    CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getLearningWritingItem(int learningTopicId) {
        List<LearningItem> learningItemList = new ArrayList<>();
        LearningItem a = new LearningItem();
        a.setLearningItemImage("https://www.europascience.com/wp-content/uploads/2018/06/41026708-example-white-stamp-text-on-red-backgroud.jpg");
        a.setLearningItemTitle("The bibe");
        learningItemList.add(a);

        LearningItem b = new LearningItem();
        b.setLearningItemImage("https://www.europascience.com/wp-content/uploads/2018/06/41026708-example-white-stamp-text-on-red-backgroud.jpg");
        b.setLearningItemTitle("The biba");
        learningItemList.add(b);

        LearningItem c = new LearningItem();
        c.setLearningItemImage("https://www.europascience.com/wp-content/uploads/2018/06/41026708-example-white-stamp-text-on-red-backgroud.jpg");
        c.setLearningItemTitle("The biba");
        learningItemList.add(c);

        LearningItem d = new LearningItem();
        d.setLearningItemImage("https://www.europascience.com/wp-content/uploads/2018/06/41026708-example-white-stamp-text-on-red-backgroud.jpg");
        d.setLearningItemTitle("The biba");
        learningItemList.add(d);

        getMvpView().setupLearningItem(learningItemList);
    }
}
