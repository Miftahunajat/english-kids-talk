package com.squishydev.setoz.englishkidstalk.di.componen;

import com.squishydev.setoz.englishkidstalk.di.PerService;
import com.squishydev.setoz.englishkidstalk.di.module.ServiceModule;

import dagger.Component;

/**
 * Created by miftahun on 6/11/18.
 * <p>
 * Author Miftahun Najat
 * Email miftahunajat@gmail.com
 * Github https://github.com/miftahunajat
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

}