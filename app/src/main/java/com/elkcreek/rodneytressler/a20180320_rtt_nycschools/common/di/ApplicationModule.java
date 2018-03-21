package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rodneytressler on 3/20/18.
 */


@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context providesApplicationContect() {
        return application;
    }
}
