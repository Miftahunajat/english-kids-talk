package com.squishydev.setoz.englishkidstalk.data;

import com.squishydev.setoz.englishkidstalk.data.db.DbHelper;
import com.squishydev.setoz.englishkidstalk.data.network.ApiHelper;
import com.squishydev.setoz.englishkidstalk.data.prefs.PreferencesHelper;

/**
 * Created by miftahun on 9/15/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public interface DataManager extends ApiHelper,DbHelper,PreferencesHelper {

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_LOCAL_LOGIN(1),
        LOGGED_IN_MODE_SERVER_LOGIN(2);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
