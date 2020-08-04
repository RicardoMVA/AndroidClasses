package com.ricardo.searchdev.util;

import com.ricardo.searchdev.model.Dev;
import com.ricardo.searchdev.model.DevMessage;
import com.ricardo.searchdev.model.DevRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DevService {
    @GET("devs/all/")
    Call<List<Dev>> getAllDevs();

    @GET("/")
    Call<DevMessage> getMessage(@Query("name") String name);

    @GET("devs/")
    Call<List<Dev>> getDevsByLike(@Header("user") String userId);

    @Headers("Contenty-Type: application/json")
    @POST("devs/")
    Call<Dev> add(@Body DevRequest devRequest);
}
