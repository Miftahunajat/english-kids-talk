package com.squishydev.setoz.englishkidstalk.ui.buatakun;

import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpPresenter;

@PerActivity
public interface BuatAkunMvpPresenter<V extends BuatAkunMvpView> extends MvpPresenter<V> {

    void registerUser(String name, String password);

    String getNama();
}

