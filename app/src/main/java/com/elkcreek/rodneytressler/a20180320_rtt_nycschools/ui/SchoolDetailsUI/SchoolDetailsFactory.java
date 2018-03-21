package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.SchoolDetailsUI;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsApi;

import javax.inject.Inject;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class SchoolDetailsFactory implements ViewModelProvider.Factory {

    /**Provides Dependencies for SchoolDetailsViewModel */

    private final SchoolsApi schoolsApi;

    @Inject
    public SchoolDetailsFactory(SchoolsApi schoolsApi) {
        this.schoolsApi = schoolsApi;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(SchoolDetailsViewModel.class)) {
            return (T) new SchoolDetailsViewModel(schoolsApi);
        }
        return null;
    }
}
