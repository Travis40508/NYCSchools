package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.MainView;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.R;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.databinding.ActivityMainBinding;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModelFactory factory;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = getViewModel();
        binding.setVm(viewModel);
        viewModel.init();

        observeSchoolsList();
    }

    private void observeSchoolsList() {
        viewModel.getSchools().observe(this, new Observer<List<SchoolsRetrofit.School>>() {
            @Override
            public void onChanged(@Nullable List<SchoolsRetrofit.School> schools) {
                for(SchoolsRetrofit.School item : schools) {
                    Log.d("@@@@", item.getSchoolName());
                }
            }
        });
    }

    private MainViewModel getViewModel() {
        return ViewModelProviders.of(this, factory).get(MainViewModel.class);
    }
}
