package com.squishydev.setoz.englishkidstalk.data.network;

import com.squishydev.setoz.englishkidstalk.R;
import com.squishydev.setoz.englishkidstalk.data.model.Difficulty;
import com.squishydev.setoz.englishkidstalk.data.model.LearningCategory;
import com.squishydev.setoz.englishkidstalk.data.model.LearningItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by miftahun on 9/21/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private String animalExampleUrl = "http://irefindex.org/wiki/images/a/a9/Example.jpg";

    @Inject
    public AppApiHelper() {

    }

    @Override
    public Single<List<LearningCategory>> getLearningCategory(Difficulty difficulty, String type) {
        List<LearningCategory> list = new ArrayList<>();
        list.add(new LearningCategory(0,"Animal",animalExampleUrl));
        list.add(new LearningCategory(1,"Cars",animalExampleUrl));
        list.add(new LearningCategory(2,"Pikopo",animalExampleUrl));

        return Single.just(list);
    }

    @Override
    public Single<List<LearningItem>> getLearningItem(int learningCategoryId) {
        List<LearningItem> list = new ArrayList<>();
        list.add(new LearningItem("Deer", R.drawable.deer,R.raw.deer));
        list.add(new LearningItem("Lion", R.drawable.lion,R.raw.lion));
        list.add(new LearningItem("Butterfly", R.drawable.butterfly,R.raw.butterfly));
        list.add(new LearningItem("Cat", R.drawable.cat,R.raw.cat));
        list.add(new LearningItem("Monkey", R.drawable.monkey,R.raw.monkey));
        return Single.just(list);
    }
}