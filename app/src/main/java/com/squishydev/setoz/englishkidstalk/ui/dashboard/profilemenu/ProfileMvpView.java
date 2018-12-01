package com.squishydev.setoz.englishkidstalk.ui.dashboard.profilemenu;

import com.squishydev.setoz.englishkidstalk.data.network.model.Inventory;
import com.squishydev.setoz.englishkidstalk.data.network.model.User;
import com.squishydev.setoz.englishkidstalk.ui.base.MvpView;

public interface ProfileMvpView extends MvpView {


    void updateProfile(User user);

    void setAvatarFromInventory(int type, Inventory inventory);

    void updateRank(int position);
}
