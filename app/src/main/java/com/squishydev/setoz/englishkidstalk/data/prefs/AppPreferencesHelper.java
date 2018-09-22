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

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public void simpanNama(String nama) {
        mPrefs.edit().putString("nama", nama).apply();
    }

    @Override
    public String getNama() {
        return mPrefs.getString("nama", null);
    }

    @Override
    public void setAvatar(int avatar) {
        mPrefs.edit().putInt("avatar", avatar).apply();
    }

    @Override
    public int getAvatar() {
        return mPrefs.getInt("avatar",0);
    }

}
