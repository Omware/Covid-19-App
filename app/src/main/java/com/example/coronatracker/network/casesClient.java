package com.example.coronatracker.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class casesClient {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://covid19.mathdro.id/";


    public static Api getCasesClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api.class);
    }
}
