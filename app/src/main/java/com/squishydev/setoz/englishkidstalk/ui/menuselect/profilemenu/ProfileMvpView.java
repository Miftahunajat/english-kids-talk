package com.squishydev.setoz.englishkidstalk.ui.menuselect.profilemenu;

import com.squishydev.setoz.englishkidstalk.data.model.User;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

public interface ProfileMvpView extends MvpView {

    void updateProfile(User user);
}
