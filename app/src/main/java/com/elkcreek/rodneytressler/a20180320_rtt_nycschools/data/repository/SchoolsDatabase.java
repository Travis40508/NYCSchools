package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;

/**
 * Created by rodneytressler on 3/21/18.
 */

/** Database used for storing data */
@Database(version = 2, entities = {SchoolsRetrofit.School.class, SchoolsRetrofit.SchoolDetails.class}, exportSchema = false)
public abstract class SchoolsDatabase extends RoomDatabase{

    abstract public SchoolsDao schoolsDao();
}
