package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.SchoolDetailsUI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.R;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.databinding.FragmentSchoolDetailsBinding;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.MainView.MainActivity;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class SchoolDetailsFragment extends Fragment {

    /**Deals with presentation components */

    private SchoolsRetrofit.School school;
    private SchoolDetailsViewModel viewModel;

    @Inject
    SchoolDetailsFactory factory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        FragmentSchoolDetailsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_school_details, container, false);
        View view = binding.getRoot();

        viewModel = getVm();
        binding.setVm(viewModel);

        school = getArguments().getParcelable(MainActivity.TAG);
        viewModel.initSchool(school.getSchoolDbn());

        return view;
    }

    private SchoolDetailsViewModel getVm() {
        return ViewModelProviders.of(this, factory).get(SchoolDetailsViewModel.class);
    }

    public static SchoolDetailsFragment newInstance() {

        Bundle args = new Bundle();

        SchoolDetailsFragment fragment = new SchoolDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
