package com.squishydev.setoz.englishkidstalk.di.module;


import android.app.Application;
import android.content.Context;

import com.squishydev.setoz.englishkidstalk.Config;
import com.squishydev.setoz.englishkidstalk.data.AppDataManager;
import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.data.db.AppDbHelper;
import com.squishydev.setoz.englishkidstalk.data.db.DbHelper;
import com.squishydev.setoz.englishkidstalk.data.network.ApiHelper;
import com.squishydev.setoz.englishkidstalk.data.network.AppApiHelper;
import com.squishydev.setoz.englishkidstalk.data.prefs.AppPreferencesHelper;
import com.squishydev.setoz.englishkidstalk.data.prefs.PreferencesHelper;
import com.squishydev.setoz.englishkidstalk.di.ApplicationContext;
import com.squishydev.setoz.englishkidstalk.di.DatabaseInfo;
import com.squishydev.setoz.englishkidstalk.di.PreferenceInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by miftahun on 6/11/18.
 * <p>
 * Author Miftahun Najat
 * Email miftahunajat@gmail.com
 * Github https://github.com/miftahunajat
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "database";
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return Config.PREF_NAME;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .build();
    }
}
