package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.SchoolDetailsUI;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsApi;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.repository.SchoolsDatabase;

import java.util.List;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class SchoolDetailsViewModel extends ViewModel {

    private LiveData<List<SchoolsRetrofit.SchoolDetails>> school;
    public ObservableField<String> readingScore;
    public ObservableField<String> writingScore;
    public ObservableField<String> mathScore;
    public ObservableField<String> totalTestTakers;
    private final SchoolsApi schoolsApi;

    public SchoolDetailsViewModel(SchoolsApi schoolsApi, SchoolsDatabase schoolsDatabase) {
        this.schoolsApi = schoolsApi;
        readingScore = new ObservableField<>("Reading Score - N/A");
        writingScore = new ObservableField<>("Writing Score - N/A");
        mathScore = new ObservableField<>("Math Score - N/A");
        totalTestTakers = new ObservableField<>("Test Takers - N/A");
    }

    /**Returns school data via the school DBN. Would've rather stored this in an SQLite database for performance improvements, but ran out of
     * time due to work commitments.  */
    public void initSchool(String schoolDbn) {
        if(school != null) {
            return;
        }

        school = schoolsApi.getSchool(schoolDbn);

    }

    public LiveData<List<SchoolsRetrofit.SchoolDetails>> getSchool() {
        return school;
    }

    public void updateView(SchoolsRetrofit.SchoolDetails schoolDetails) {
        readingScore.set("Reading Score - " + schoolDetails.getReadingScore());
        writingScore.set("Writing Score - " + schoolDetails.getWritingScore());
        mathScore.set("Math Score - " + schoolDetails.getMathScore());
        totalTestTakers.set("Test Takers - " + schoolDetails.getTotalTestTakers());
    }
}
