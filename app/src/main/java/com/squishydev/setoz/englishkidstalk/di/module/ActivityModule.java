package com.squishydev.setoz.englishkidstalk.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.squishydev.setoz.englishkidstalk.di.ActivityContext;
import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.buatAkun.BuatAkunMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.buatAkun.BuatAkunMvpView;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaMvpPresenter;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaMvpView;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by miftahun on 6/11/18.
 * <p>
 * Author Miftahun Najat
 * Email miftahunajat@gmail.com
 * Github https://github.com/miftahunajat
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    InputNamaMvpPresenter<InputNamaMvpView> provideInputNamaMvpPresenter(
            InputNamaMvpPresenter<InputNamaMvpView> presenter){
        return presenter;
    }

    @Provides
    BuatAkunMvpPresenter<BuatAkunMvpView> provideBuatAkunMvpPresenter(
            BuatAkunMvpPresenter<BuatAkunMvpView> presenter){
        return presenter;
    }

}
