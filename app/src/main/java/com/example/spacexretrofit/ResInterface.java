package com.example.spacexretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResInterface {

    @GET("v2/launches")
    Call<List<Repo>> getRepo();
}
