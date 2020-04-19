package com.example.coronatracker.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronatracker.R;
import com.example.coronatracker.adapters.CoronaAdapter;
import com.example.coronatracker.models.Details.DetailsModelResponse;
import com.example.coronatracker.network.Api;
import com.example.coronatracker.network.countriesClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private CoronaAdapter mAdapter;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    List<DetailsModelResponse> detailsModelResponses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        startsearch();
        getCountries();


    }

    private void getCountries() {
        Api api = countriesClient.getCountries();
        Call<List<DetailsModelResponse>> call = api.getallCountries();
        call.enqueue(new Callback<List<DetailsModelResponse>>() {
            @Override
            public void onResponse(Call<List<DetailsModelResponse>> call, Response<List<DetailsModelResponse>> response) {
                if (response.isSuccessful()) {

                    Log.d("qwerty", "-------------countries passed---------------");

                    detailsModelResponses = response.body();
                    mAdapter = new CoronaAdapter(SearchActivity.this, detailsModelResponses);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<List<DetailsModelResponse>> call, Throwable t) {
                Log.d("Fail", t.getMessage());
                Log.d("qwerty", "-------------countries failed---------------");

            }
        });
    }


    private void startsearch() {
        SearchView searchView = findViewById(R.id.search);
        searchView.isQueryRefinementEnabled();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                mRecyclerView.setVisibility(View.VISIBLE);

                if (query == null || query.length() == 0) {
                    mAdapter = new CoronaAdapter(SearchActivity.this, detailsModelResponses);
                } else {
                    mAdapter.getFilter().filter(query);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return true;
            }


        });
    }


}
