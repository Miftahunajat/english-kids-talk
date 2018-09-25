package com.squishydev.setoz.englishkidstalk.di.componen;


import com.squishydev.setoz.englishkidstalk.di.PerActivity;
import com.squishydev.setoz.englishkidstalk.di.module.ActivityModule;
import com.squishydev.setoz.englishkidstalk.ui.buatAkun.BuatAkunActivity;
import com.squishydev.setoz.englishkidstalk.ui.inputnama.InputNamaActivity;

import dagger.Component;

/**
 * Created by miftahun on 6/11/18.
 * <p>
 * Author Miftahun Najat
 * Email miftahunajat@gmail.com
 * Github https://github.com/miftahunajat
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(InputNamaActivity inputNamaActivity);

    void inject(BuatAkunActivity buatAkunActivity);
}
