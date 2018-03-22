package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.SchoolDetailsUI;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsApi;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.repository.SchoolsDatabase;

import javax.inject.Inject;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class SchoolDetailsFactory implements ViewModelProvider.Factory {

    /**Provides Dependencies for SchoolDetailsViewModel */

    private final SchoolsApi schoolsApi;
    private final SchoolsDatabase schoolsDatabase;

    @Inject
    public SchoolDetailsFactory(SchoolsApi schoolsApi, SchoolsDatabase schoolsDatabase) {
        this.schoolsApi = schoolsApi;
        this.schoolsDatabase = schoolsDatabase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(SchoolDetailsViewModel.class)) {
            return (T) new SchoolDetailsViewModel(schoolsApi, schoolsDatabase);
        }
        return null;
    }
}
