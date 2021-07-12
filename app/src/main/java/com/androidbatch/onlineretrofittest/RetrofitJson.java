package com.androidbatch.onlineretrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface RetrofitJson {

    @GET("apod?api_key=DEMO_KEY&count=25")
    Call<List<ImageDetailsModel>> getImages();



}
