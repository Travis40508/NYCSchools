package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rodneytressler on 3/20/18.
 */

public interface SchoolsRetrofit {
    /**Class for providing models and api calls for said-models */

    @GET("/resource/97mf-9njv.json")
    Call<List<School>> getSchools();

    @GET("/resource/734v-jeq5.json")
    Call<List<SchoolDetails>> getSchool(@Query("dbn") String schoolDbn);


    @Entity
    class School implements Parcelable{

        @PrimaryKey(autoGenerate = true)
        int id;


        @SerializedName("school_name")
        @Expose private String schoolName;

        @SerializedName("neighborhood")
        @Expose private String neighborhood;

        @SerializedName("dbn")
        @Expose private String schoolDbn;


        public School() {

        }

        protected School(Parcel in) {
            schoolName = in.readString();
            neighborhood = in.readString();
            schoolDbn = in.readString();
        }

        public static final Creator<School> CREATOR = new Creator<School>() {
            @Override
            public School createFromParcel(Parcel in) {
                return new School(in);
            }

            @Override
            public School[] newArray(int size) {
                return new School[size];
            }
        };

        public String getSchoolName() {
            return schoolName;
        }

        public String getNeighborhood() {
            return neighborhood;
        }


        public String getSchoolDbn() {
            return schoolDbn;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(schoolName);
            dest.writeString(neighborhood);
            dest.writeString(schoolDbn);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }

        public void setNeighborhood(String neighborhood) {
            this.neighborhood = neighborhood;
        }

        public void setSchoolDbn(String schoolDbn) {
            this.schoolDbn = schoolDbn;
        }

        public static Creator<School> getCREATOR() {
            return CREATOR;
        }
    }

    @Entity
    class SchoolDetails {

        @PrimaryKey(autoGenerate = true)
        int id;

        @SerializedName("dbn")
        @Expose private String schoolDbn;

        @SerializedName("school_name")
        @Expose private String schoolName;

        @SerializedName("sat_critical_reading_avg_score")
        @Expose private String readingScore;

        @SerializedName("sat_math_avg_score")
        @Expose private String mathScore;

        @SerializedName("sat_writing_avg_score")
        @Expose private String writingScore;

        @SerializedName("num_of_sat_test_takers")
        @Expose private String totalTestTakers;

        public SchoolDetails() {

        }

        public String getReadingScore() {
            return readingScore;
        }

        public String getMathScore() {
            return mathScore;
        }

        public String getWritingScore() {
            return writingScore;
        }

        public String getTotalTestTakers() {
            return totalTestTakers;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setReadingScore(String readingScore) {
            this.readingScore = readingScore;
        }

        public void setMathScore(String mathScore) {
            this.mathScore = mathScore;
        }

        public void setWritingScore(String writingScore) {
            this.writingScore = writingScore;
        }

        public void setTotalTestTakers(String totalTestTakers) {
            this.totalTestTakers = totalTestTakers;
        }

        public String getSchoolDbn() {
            return schoolDbn;
        }

        public void setSchoolDbn(String schoolDbn) {
            this.schoolDbn = schoolDbn;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }
    }
}
