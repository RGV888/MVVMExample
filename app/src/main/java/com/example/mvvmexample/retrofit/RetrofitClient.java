package com.example.mvvmexample.retrofit;

import com.example.mvvmexample.Utils.AppAPIUrls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit retrofit;

    public static Retrofit getRetrofitClient(){

        if(retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(AppAPIUrls.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
}
