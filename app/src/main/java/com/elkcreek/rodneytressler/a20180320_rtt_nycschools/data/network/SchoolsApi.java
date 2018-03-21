package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network;

import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by rodneytressler on 3/20/18.
 */

public interface SchoolsApi {
    /**Interface for keeping our impl class data tied to a data contract and to improve testing later on */

    LiveData<List<SchoolsRetrofit.School>> getSchools();

    LiveData<List<SchoolsRetrofit.SchoolDetails>> getSchool(String schoolDbn);
}
