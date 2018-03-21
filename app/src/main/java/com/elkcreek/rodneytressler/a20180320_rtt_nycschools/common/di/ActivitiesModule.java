package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.di;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.MainView.MainActivity;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.SchoolDetailsUI.SchoolDetailsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by rodneytressler on 3/20/18.
 */


@Module
public abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivityInjector();

    @ContributesAndroidInjector
    abstract SchoolDetailsFragment contributesSchoolDetailsFragmentInjector();
}
