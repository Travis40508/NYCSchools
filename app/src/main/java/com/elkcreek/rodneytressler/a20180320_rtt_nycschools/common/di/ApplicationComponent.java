package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.di;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.SchoolsApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by rodneytressler on 3/20/18.
 */

/**Simple component class for providing objects throughout our application */
@Singleton
@Component(modules = {AndroidInjectionModule.class, ApplicationModule.class, ActivitiesModule.class, NetworkModule.class, DatabaseModule.class})
public interface ApplicationComponent {

    void inject(SchoolsApplication schoolsApplication);
}
