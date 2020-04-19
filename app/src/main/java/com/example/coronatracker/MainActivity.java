package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coronatracker.adapters.CoronaAdapter;
import com.example.coronatracker.models.Details.DetailsModelResponse;
import com.example.coronatracker.models.cases.CasesModelResponse;
import com.example.coronatracker.network.Api;
import com.example.coronatracker.network.casesClient;
import com.example.coronatracker.network.countriesClient;
import com.example.coronatracker.ui.SearchActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.sanju.motiontoast.MotionToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.btnsearch)
    FloatingActionButton msearch;
    public static final String TAG = "MainActivity";
    private CasesModelResponse mresponse;
    private CoronaAdapter mAdapter;
    private List<DetailsModelResponse> mDetailsModelResponseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ButterKnife.bind(this);
        msearch.setOnClickListener(this);

        getCases();
        getCountries();

    }

    private void getCountries() {
        Api api = countriesClient.getCountries();
        Call<List<DetailsModelResponse>> call = api.getallCountries();
        Log.d(TAG, "Response : " + call.request().url().toString());
        call.enqueue(new Callback<List<DetailsModelResponse>>() {
            @Override
            public void onResponse(Call<List<DetailsModelResponse>> call, Response<List<DetailsModelResponse>> response) {
                if (response.isSuccessful()) {

                    Log.d("qwerty", "-------------countries passed---------------");

                    mDetailsModelResponseList = response.body();
                    mAdapter = new CoronaAdapter(MainActivity.this, mDetailsModelResponseList);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
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

    private void getCases() {

        Api api = casesClient.getCasesClient();
        Call<CasesModelResponse> call = api.getallcases();
        Log.d(TAG, "Response : " + call.request().url().toString());
        call.enqueue(new Callback<CasesModelResponse>() {
            @Override
            public void onResponse(Call<CasesModelResponse> call, Response<CasesModelResponse> response) {

                if (response.isSuccessful()) {
                    Log.d(TAG, "-------------SUCCESS------------");
//                    TextView cases = findViewById(R.id.cases);
//                    TextView deaths = findViewById(R.id.deaths);
//                    TextView recovered = findViewById(R.id.recovered);
                    ImageView allcases = findViewById(R.id.relative1);

                    mresponse = response.body();
//                    cases.setText(String.valueOf(mresponse.getConfirmed().getValue()));
//                    deaths.setText(String.valueOf(mresponse.getDeaths().getValue()));
//                    recovered.setText(String.valueOf(mresponse.getRecovered().getValue()));
                    Picasso.get().load(mresponse.getImage()).into(allcases);

                }
            }

            @Override
            public void onFailure(Call<CasesModelResponse> call, Throwable t) {

                Log.d(TAG, "-------------FAILED------------");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                MotionToast.Companion.darkToast((Activity) MainActivity.this, "Settings Coming Soon",
                        MotionToast.Companion.getTOAST_INFO(),
                        MotionToast.Companion.getGRAVITY_BOTTOM(),
                        MotionToast.Companion.getLONG_DURATION(),
                        ResourcesCompat.getFont(this, R.font.helvetica_regular));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {

        if (v == msearch) {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        }
    }
}
