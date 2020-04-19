package com.example.coronatracker.network;

import com.example.coronatracker.models.Details.DetailsModelResponse;
import com.example.coronatracker.models.cases.CasesModelResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api")
    Call<CasesModelResponse> getallcases();

    @GET("v2/countries")
    Call<List<DetailsModelResponse>> getallCountries();
}
