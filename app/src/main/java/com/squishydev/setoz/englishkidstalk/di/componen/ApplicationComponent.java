package com.squishydev.setoz.englishkidstalk.di.componen;

import android.app.Application;
import android.content.Context;

import com.squishydev.setoz.englishkidstalk.App;
import com.squishydev.setoz.englishkidstalk.data.DataManager;
import com.squishydev.setoz.englishkidstalk.di.ApplicationContext;
import com.squishydev.setoz.englishkidstalk.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by miftahun on 6/11/18.
 * <p>
 * Author Miftahun Najat
 * Email miftahunajat@gmail.com
 * Github https://github.com/miftahunajat
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}