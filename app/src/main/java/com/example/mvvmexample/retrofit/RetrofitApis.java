package com.example.mvvmexample.retrofit;

import com.example.mvvmexample.Models.StroryResponse;
import com.example.mvvmexample.Utils.AppAPIUrls;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApis {

    @GET(AppAPIUrls.API_POSTS_URL)
    Call<StroryResponse> getStorysList(@Query("tags") String taga,@Query("page") int pageNo);

}
