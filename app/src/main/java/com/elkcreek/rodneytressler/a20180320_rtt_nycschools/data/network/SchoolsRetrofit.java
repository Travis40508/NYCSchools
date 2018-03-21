package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rodneytressler on 3/20/18.
 */

public interface SchoolsRetrofit {

    @GET("/resource/97mf-9njv.json")
    Call<List<School>> getSchools();


    class School {
        @SerializedName("school_name")
        @Expose private String schoolName;

        @SerializedName("neighborhood")
        @Expose private String neighborhood;

        public String getSchoolName() {
            return schoolName;
        }

        public String getNeighborhood() {
            return neighborhood;
        }
    }
}
