package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class SchoolsApiImpl implements SchoolsApi {

    private final SchoolsRetrofit schoolsRetrofit;

    public SchoolsApiImpl(SchoolsRetrofit schoolsRetrofit) {
        this.schoolsRetrofit = schoolsRetrofit;
    }


    @Override
    public LiveData<List<SchoolsRetrofit.School>> getSchools() {
        final MutableLiveData<List<SchoolsRetrofit.School>> schoolsList = new MutableLiveData<>();

        schoolsRetrofit.getSchools().enqueue(new Callback<List<SchoolsRetrofit.School>>() {
            @Override
            public void onResponse(Call<List<SchoolsRetrofit.School>> call, Response<List<SchoolsRetrofit.School>> response) {
                if(response.isSuccessful()) {
                    schoolsList.setValue(response.body());
                } else {
                    Log.e("RESPONSE UNSUCCESSFUL", response.message());
                }
            }

            @Override
            public void onFailure(Call<List<SchoolsRetrofit.School>> call, Throwable t) {
                Log.e("RESPONSE FAILURE", t.getMessage());
            }
        });

        return schoolsList;
    }

    @Override
    public LiveData<SchoolsRetrofit.School> getSchool(String schoolName) {
        final MutableLiveData school = new MutableLiveData();

        schoolsRetrofit.getSchool(schoolName).enqueue(new Callback<SchoolsRetrofit.School>() {
            @Override
            public void onResponse(Call<SchoolsRetrofit.School> call, Response<SchoolsRetrofit.School> response) {
                if(response.isSuccessful()) {
                    school.setValue(response.body());
                } else {
                    Log.e("RESPONSE UNSUCCESSFUL", response.message());
                }
            }

            @Override
            public void onFailure(Call<SchoolsRetrofit.School> call, Throwable t) {
                Log.e("RESPONSE FAILURE", t.getMessage());
            }
        });


        return school;
    }
}
