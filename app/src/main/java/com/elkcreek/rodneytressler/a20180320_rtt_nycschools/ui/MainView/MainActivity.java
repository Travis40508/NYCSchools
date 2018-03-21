package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.MainView;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.R;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.adapters.SchoolsAdapter;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.databinding.ActivityMainBinding;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.ui.SchoolDetailsUI.SchoolDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements SchoolsAdapter.Callback{

    @Inject
    MainViewModelFactory factory;

    private MainViewModel viewModel;
    private RecyclerView recyclerView;
    private SchoolsAdapter adapter;
    public static String TAG = "SCHOOL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = getViewModel();
        binding.setVm(viewModel);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<SchoolsRetrofit.School> schoolList = new ArrayList<>();
        adapter = new SchoolsAdapter(schoolList, this);
        recyclerView.setAdapter(adapter);

        viewModel.init();

        observeSchoolsList();
    }

    private void observeSchoolsList() {
        viewModel.getSchools().observe(this, new Observer<List<SchoolsRetrofit.School>>() {
            @Override
            public void onChanged(@Nullable List<SchoolsRetrofit.School> schools) {
                adapter.setSchools(schools);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private MainViewModel getViewModel() {
        return ViewModelProviders.of(this, factory).get(MainViewModel.class);
    }

    @Override
    public void onSchoolClicked(SchoolsRetrofit.School school) {
        viewModel.getSchool(school.getSchoolName());
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, school);
        SchoolDetailsFragment detailsFragment = SchoolDetailsFragment.newInstance();
        detailsFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, detailsFragment).commit();
    }
}
