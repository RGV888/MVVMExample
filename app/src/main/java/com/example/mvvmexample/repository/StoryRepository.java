package com.example.mvvmexample.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.mvvmexample.Models.Hit;
import com.example.mvvmexample.Models.StroryResponse;
import com.example.mvvmexample.retrofit.RetrofitApis;
import com.example.mvvmexample.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StoryRepository {
    private MutableLiveData<List<Hit>> hisLive = new MutableLiveData<>();
    private RetrofitApis retrofitApis;
    private int maxPageNo;

    public StoryRepository() {
        retrofitApis = RetrofitClient.getRetrofitClient().create(RetrofitApis.class);
    }


    public LiveData<List<Hit>> getLiveList() {

        if (hisLive == null) {
            hisLive = new MutableLiveData<>();
        }
        return hisLive;
    }

    public void callForStoryList(int pageNo) {

        if (pageNo > maxPageNo) {
            return;
        }

        retrofitApis.getStorysList("storys", pageNo).enqueue(new Callback<StroryResponse>() {
            @Override
            public void onResponse(Call<StroryResponse> call, Response<StroryResponse> response) {

                if (response.isSuccessful()) {
                    maxPageNo = response.body().getNbPages();
                    hisLive.postValue(response.body().getHits());

                }

            }

            @Override
            public void onFailure(Call<StroryResponse> call, Throwable t) {
                hisLive.postValue(null);
            }
        });
    }

}
