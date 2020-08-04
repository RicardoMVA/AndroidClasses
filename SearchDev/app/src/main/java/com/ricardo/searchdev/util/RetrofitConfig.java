package com.ricardo.searchdev.util;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://exampletindev-backend.herokuapp.com/" )
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public DevService getDevService() {
        return this.retrofit.create(DevService.class);
    }
}
