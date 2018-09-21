package com.squishydev.setoz.englishkidstalk.data;

import android.content.Context;

import com.squishydev.setoz.englishkidstalk.data.db.DbHelper;
import com.squishydev.setoz.englishkidstalk.data.network.ApiHelper;
import com.squishydev.setoz.englishkidstalk.data.prefs.PreferencesHelper;
import com.squishydev.setoz.englishkidstalk.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by miftahun on 9/20/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }
}
