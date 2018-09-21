package com.squishydev.setoz.englishkidstalk.ui.base;

import com.androidnetworking.error.ANError;

/**
 * Created by miftahun on 9/21/18.
 * Email : miftahunajat@gmail.com
 * Github : https://github.com/miftahunajat/
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ANError error);

//    void setUserAsLoggedOut();
}
