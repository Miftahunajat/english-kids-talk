package com.squishydev.setoz.englishkidstalk.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.squishydev.setoz.englishkidstalk.data.DataManager;
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

    public static final String PREF_KEY_NAME = "name";
    public static final String PREF_KEY_AVATAR = "avatar";
    public static final String PREF_KEY_USERNAME = "username";
    public static final String PREF_KEY_PASSWORD = "password";
    public static final String PREF_KEY_LOGGED_IN = "logged_in";
    public static final String PREF_KEY_USER_ID = "user-id";



    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public void setPrefName(String name) {
        mPrefs.edit().putString(PREF_KEY_NAME,name).apply();
    }

    @Override
    public String getPrefName() {
        return mPrefs.getString(PREF_KEY_NAME,"");
    }

    @Override
    public void setAvatarType(int avatar) {
        mPrefs.edit().putInt(PREF_KEY_AVATAR,avatar).apply();
    }

    @Override
    public int getAvatarType() {
        return mPrefs.getInt(PREF_KEY_AVATAR,-1);
    }

    @Override
    public void setLoggedInMode(DataManager.LoggedInMode loggedInMode) {
        mPrefs.edit().putInt(PREF_KEY_LOGGED_IN,loggedInMode.getType()).apply();
    }

    @Override
    public int getLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_LOGGED_IN,-1);
    }

    @Override
    public void setUserId(String id) {
        mPrefs.edit().putString(PREF_KEY_USER_ID,id).apply();
    }

    @Override
    public String getUserId() {
        return mPrefs.getString(PREF_KEY_USER_ID,"");
    }


}
