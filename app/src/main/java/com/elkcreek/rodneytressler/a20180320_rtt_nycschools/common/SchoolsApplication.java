package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common;

import android.app.Activity;
import android.app.Application;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.di.ApplicationComponent;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.di.ApplicationModule;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.di.DaggerApplicationComponent;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.di.NetworkModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class SchoolsApplication extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    private String baseUrl = "https://data.cityofnewyork.us";

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule(baseUrl))
                .applicationModule(new ApplicationModule(this))
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
