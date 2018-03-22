package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.MainView;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsApi;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.repository.SchoolsDatabase;

import java.util.List;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class MainViewModel extends ViewModel {


    private LiveData<List<SchoolsRetrofit.School>> schools;
    private final SchoolsApi schoolsApi;

    public MainViewModel(SchoolsApi schoolsApi, SchoolsDatabase schoolsDatabase) {
        this.schoolsApi = schoolsApi;
    }

    public void init() {
        /**Sets livedata schools equal to the value of the API call. would've rather this had been a local SQLite database */
        if(this.schools != null) {
            return;
        }
        schools = schoolsApi.getSchools();
    }

    public LiveData<List<SchoolsRetrofit.School>> getSchools() {
        return schools;
    }


}
