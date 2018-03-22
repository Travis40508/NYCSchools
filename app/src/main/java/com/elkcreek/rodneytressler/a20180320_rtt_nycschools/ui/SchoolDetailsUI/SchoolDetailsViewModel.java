package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.SchoolDetailsUI;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.Nullable;
import android.util.Log;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsApi;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.repository.SchoolsDatabase;

import java.util.List;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class SchoolDetailsViewModel extends ViewModel {

    private final SchoolsDatabase schoolsDatabase;
    public ObservableField<String> readingScore;
    public ObservableField<String> writingScore;
    public ObservableField<String> mathScore;
    public ObservableField<String> totalTestTakers;
    public ObservableField<String> schoolName;
    private final SchoolsApi schoolsApi;

    public SchoolDetailsViewModel(SchoolsApi schoolsApi, SchoolsDatabase schoolsDatabase) {
        this.schoolsApi = schoolsApi;
        this.schoolsDatabase = schoolsDatabase;
        readingScore = new ObservableField<>("Reading Score - N/A");
        writingScore = new ObservableField<>("Writing Score - N/A");
        mathScore = new ObservableField<>("Math Score - N/A");
        totalTestTakers = new ObservableField<>("Test Takers - N/A");
        schoolName = new ObservableField<>("School Name Unavailable");
    }

    /**
     * Uses SQLite database to store clicked school. This way it only has to perform any work the first time and retrieve it from the database
     * every time after.
     */
    public void initSchool(final String schoolDbn) {


        if (schoolsDatabase.schoolsDao().findSchoolByDbn(schoolDbn) != null) {
            updateView(schoolsDatabase.schoolsDao().findSchoolByDbn(schoolDbn));
        } else {
            schoolsApi.getSchool(schoolDbn).observeForever(new Observer<List<SchoolsRetrofit.SchoolDetails>>() {
                @Override
                public void onChanged(@Nullable List<SchoolsRetrofit.SchoolDetails> schoolDetails) {
                    schoolsDatabase.schoolsDao().insertSchoolDetails(schoolDetails.get(0));
                    updateView(schoolsDatabase.schoolsDao().findSchoolByDbn(schoolDbn));
                }
            });

        }
    }


    public void updateView(SchoolsRetrofit.SchoolDetails schoolDetails) {
        schoolName.set(schoolDetails.getSchoolName());
        readingScore.set("Reading Score - " + schoolDetails.getReadingScore());
        writingScore.set("Writing Score - " + schoolDetails.getWritingScore());
        mathScore.set("Math Score - " + schoolDetails.getMathScore());
        totalTestTakers.set("Test Takers - " + schoolDetails.getTotalTestTakers());
    }
}
