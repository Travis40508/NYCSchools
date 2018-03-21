package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.MainView;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsApi;

import javax.inject.Inject;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private SchoolsApi schoolsApi;

    @Inject
    public MainViewModelFactory(SchoolsApi schoolsApi) {
        this.schoolsApi = schoolsApi;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(schoolsApi);
        }
        return null;
    }
}
