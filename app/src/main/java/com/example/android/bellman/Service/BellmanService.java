package com.example.android.bellman.Service;

import com.example.android.bellman.Model.BellmanList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BellmanService {

    @GET("home")
    Call<BellmanList> getHome();
}
