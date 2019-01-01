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

public interface PreferencesHelper {

    void setPrefName(String name);

    String getPrefName();

    void setAvatarType(int type);

    int getAvatarType();

    void setLoggedInMode(DataManager.LoggedInMode loggedInMode);

    int getLoggedInMode();

    void setUserId(String id);

    String getUserId();

    String getToken();

    void setToken(String token);

    void setInventoryId(String inventoryId);

    String getInventoryId();

    void clearPreferenceData();
}
