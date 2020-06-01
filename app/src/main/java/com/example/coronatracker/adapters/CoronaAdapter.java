package com.example.coronatracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronatracker.R;
import com.example.coronatracker.models.Details.DetailsModelResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoronaAdapter extends RecyclerView.Adapter<CoronaAdapter.ViewHolder> implements Filterable {

    private Context mContext;
    private List<DetailsModelResponse> detailsModelResponse;

    public CoronaAdapter(Context mContext, List<DetailsModelResponse> detailsModelResponse) {
        this.mContext = mContext;
        this.detailsModelResponse = detailsModelResponse;
    }

    @NonNull
    @Override
    public CoronaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.corona_countries, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaAdapter.ViewHolder holder, int position) {
        holder.bindcases(detailsModelResponse.get(position));
    }

    @Override
    public int getItemCount() {
        return detailsModelResponse.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<DetailsModelResponse> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(detailsModelResponse);
            } else {
                String filterpattern = constraint.toString().toLowerCase().trim();

                for (DetailsModelResponse detailsModelResponse : detailsModelResponse) {
                    if (detailsModelResponse.getCountry().toLowerCase().contains(filterpattern)) {
                        filteredList.add(detailsModelResponse);
                    }
                }
            }
            FilterResults results = new FilterResults();
            if (filteredList.size() == 0) {
                filteredList.addAll(detailsModelResponse);
                results.values = filteredList;
                Toast.makeText(mContext, "No results found!!!", Toast.LENGTH_SHORT).show();
            } else {
                results.values = filteredList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            detailsModelResponse.clear();
            detailsModelResponse.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.countryflag)
        ImageView mflag;
        @BindView(R.id.countryname)
        TextView mcountryname;
        @BindView(R.id.totalcases)
        TextView mcases;
        @BindView(R.id.todaycases)
        TextView mtodaycases;
        @BindView(R.id.deaths)
        TextView mdeaths;
        @BindView(R.id.recovered)
        TextView mrecovered;
        private Context mContext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindcases(DetailsModelResponse casesModelResponse) {
            Picasso.get().load(casesModelResponse.getCountryInfo().getFlag()).into(mflag);
            mcountryname.setText(casesModelResponse.getCountry());
            mtodaycases.setText(String.valueOf(casesModelResponse.getTodayCases()));
            mcases.setText(String.valueOf(casesModelResponse.getCases()));
            mdeaths.setText(String.valueOf(casesModelResponse.getDeaths()));
            mrecovered.setText(String.valueOf(casesModelResponse.getRecovered()));
            mcountryname.setSelected(true);

        }
    }
}
