package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.di;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsApi;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsApiImpl;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rodneytressler on 3/20/18.
 */


@Module

/**Network module for providing retrofit implementations throughout application */
public class NetworkModule {

    private String baseUrl;

    public NetworkModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    Retrofit providesRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    @Provides
    SchoolsRetrofit providesSchoolRetrofit(Retrofit retrofit) {
        SchoolsRetrofit schoolsRetrofit = retrofit.create(SchoolsRetrofit.class);

        return schoolsRetrofit;
    }

    @Provides
    SchoolsApi providesSchoolsApi(SchoolsRetrofit schoolsRetrofit) {
        return new SchoolsApiImpl(schoolsRetrofit);
    }
}
