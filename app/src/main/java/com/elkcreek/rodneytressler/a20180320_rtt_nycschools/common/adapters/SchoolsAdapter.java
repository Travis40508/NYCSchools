package com.elkcreek.rodneytressler.a20180320_rtt_nycschools.common.adapters;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.R;
import com.elkcreek.rodneytressler.a20180320_rtt_nycschools.data.network.SchoolsRetrofit;

import java.util.List;

/**
 * Created by rodneytressler on 3/20/18.
 */

public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsAdapter.SchoolsViewHolder> {

    private final Callback callback;
    private List<SchoolsRetrofit.School> schoolsList;

    /** Takes in a list of schools and displays them, using a callback to deal with click events back in the main activity.*/
    public SchoolsAdapter(List<SchoolsRetrofit.School> schoolsList, Callback callback) {
        this.schoolsList = schoolsList;
        this.callback = callback;
    }

    @Override
    public SchoolsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_school, parent, false);

        return new SchoolsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SchoolsViewHolder holder, int position) {
        holder.bindSchools(schoolsList.get(position));

        holder.layout.setOnClickListener(holder.onClick(schoolsList.get(position)));
    }

    @Override
    public int getItemCount() {
        return schoolsList.size();
    }

    public void setSchools(List<SchoolsRetrofit.School> schools) {
        this.schoolsList = schools;
    }

    public class SchoolsViewHolder extends RecyclerView.ViewHolder {

        protected ConstraintLayout layout;
        protected TextView schoolName;
        protected TextView schoolNeighborhood;


        public SchoolsViewHolder(View itemView) {
            super(itemView);

            schoolName = itemView.findViewById(R.id.text_school_name);
            schoolNeighborhood = itemView.findViewById(R.id.text_school_neighborhood);
            layout = itemView.findViewById(R.id.item_layout);
        }

        public void bindSchools(SchoolsRetrofit.School school) {
            schoolName.setText(school.getSchoolName());
            schoolNeighborhood.setText(school.getNeighborhood());
        }

        public View.OnClickListener onClick(final SchoolsRetrofit.School school) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onSchoolClicked(school);
                }
            };
        }
    }

    public interface Callback {
        void onSchoolClicked(SchoolsRetrofit.School school);
    }
}
