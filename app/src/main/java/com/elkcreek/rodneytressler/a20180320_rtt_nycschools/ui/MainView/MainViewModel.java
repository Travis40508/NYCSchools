package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.MainView;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.support.annotation.Nullable;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsApi;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.repository.SchoolsDatabase;

import java.util.List;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class MainViewModel extends ViewModel {


    private final SchoolsDatabase schoolsDatabase;
    private LiveData<List<SchoolsRetrofit.School>> schools;
    private final SchoolsApi schoolsApi;

    public MainViewModel(SchoolsApi schoolsApi, final SchoolsDatabase schoolsDatabase) {
        this.schoolsApi = schoolsApi;
        this.schoolsDatabase = schoolsDatabase;

        schoolsApi.getSchools().observeForever(new Observer<List<SchoolsRetrofit.School>>() {
            @Override
            public void onChanged(@Nullable final List<SchoolsRetrofit.School> schools) {
                for (SchoolsRetrofit.School item : schools) {
                    schoolsDatabase.schoolsDao().insertSchools(item);
                }
            }
        });
    }

    public void init() {
        /**Sets livedata schools equal to the value of the API call. would've rather this had been a local SQLite database */
        if (this.schoolsDatabase != null) {
            return;
        }
    }

    public LiveData<List<SchoolsRetrofit.School>> getSchools() {
        return schools;
    }

    public SchoolsDatabase getSchoolsDatabase() {
        return schoolsDatabase;
    }
}
