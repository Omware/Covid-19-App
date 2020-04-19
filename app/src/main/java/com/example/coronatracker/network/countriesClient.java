package com.example.coronatracker.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class countriesClient {
    private static Retrofit retrofit = null;
    private static final String COUNTRIES_URL = "https://corona.lmao.ninja/";

    public static Api getCountries() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(COUNTRIES_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api.class);
    }
}
