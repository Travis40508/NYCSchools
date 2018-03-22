package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.repository.SchoolsDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rodneytressler on 3/21/18.
 */

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    SchoolsDatabase providesSchoolDatabase(Context context) {
        SchoolsDatabase db = Room.databaseBuilder(context, SchoolsDatabase.class, "schools-database")
                .allowMainThreadQueries()
                .build();
        return db;
    }
}
