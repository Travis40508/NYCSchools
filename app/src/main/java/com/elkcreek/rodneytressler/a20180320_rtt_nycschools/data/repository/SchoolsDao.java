package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;

import java.util.List;

import retrofit2.http.GET;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by rodneytressler on 3/21/18.
 */

@Dao
public interface SchoolsDao {

    @Insert(onConflict = REPLACE)
    void insertSchools(SchoolsRetrofit.School school);

    @Insert
    void insertAll(SchoolsRetrofit.School... schools);

    @Query("SELECT * FROM school")
    LiveData<List<SchoolsRetrofit.School>> getAllSchools();
}
