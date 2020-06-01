package com.example.coronatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.coronatracker.adapters.CoronaAdapter;
import com.example.coronatracker.models.Details.DetailsModelResponse;
import com.example.coronatracker.models.cases.CasesModelResponse;
import com.example.coronatracker.network.Api;
import com.example.coronatracker.network.casesClient;
import com.example.coronatracker.network.countriesClient;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.sanju.motiontoast.MotionToast;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView)
    TextView mErrorTextView;
    @BindView(R.id.progressBar)
    ProgressBar mprogressbar;
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
                mprogressbar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    Log.d("qwerty", "-------------countries passed---------------");

                    if (response.body().size() == 0) {

                        MotionToast.Companion.darkToast((Activity) MainActivity.this, "Data not Available. Please try again later",
                                MotionToast.Companion.getTOAST_WARNING(),
                                MotionToast.Companion.getGRAVITY_BOTTOM(),
                                MotionToast.Companion.getLONG_DURATION(),
                                ResourcesCompat.getFont(MainActivity.this, R.font.helvetica_regular));
                    } else {
                        mDetailsModelResponseList = response.body();
                        mAdapter = new CoronaAdapter(MainActivity.this, mDetailsModelResponseList);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFailure(Call<List<DetailsModelResponse>> call, Throwable t) {
                Log.d("Fail", Objects.requireNonNull(t.getMessage()));
                mprogressbar.setVisibility(View.GONE);
                mErrorTextView.setVisibility(View.VISIBLE);
                mErrorTextView.setText("Something went wrong, please try again later");
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
                    ImageView allcases = findViewById(R.id.relative1);
                    mresponse = response.body();
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

        MenuItem searchitem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchitem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.isEmpty()) {
                    getCountries();
                }
                mAdapter.getFilter().filter(newText);
                mRecyclerView.scrollToPosition(0);
                return false;
            }
        });
        return true;
    }

}
