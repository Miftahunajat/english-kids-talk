package com.squishydev.setoz.englishkidstalk.ui.inputnama;

import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface InputNamaMvpPresenter<V extends InputNamaMvpView> extends MvpPresenter<V> {

    void saveNama(String nama);
}

