package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network;

import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by rodneytressler on 3/20/18.
 */

public interface SchoolsApi {
    LiveData<List<SchoolsRetrofit.School>> getSchools();

    LiveData<SchoolsRetrofit.School> getSchool(String schoolName);
}
