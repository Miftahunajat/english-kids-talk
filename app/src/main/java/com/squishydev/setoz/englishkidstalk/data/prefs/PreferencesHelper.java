package com.squishydev.setoz.englishkidstalk.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.squishydev.setoz.englishkidstalk.di.ApplicationContext;
import com.squishydev.setoz.englishkidstalk.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by miftahun on 9/21/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public interface PreferencesHelper {

    void simpanNama(String nama);
    String getNama();

    void setAvatar(int avatar);
    int getAvatar();

}
