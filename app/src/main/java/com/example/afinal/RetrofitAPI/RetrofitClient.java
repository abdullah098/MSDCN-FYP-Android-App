package com.example.afinal.RetrofitAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static String BASE_URL="http://192.168.10.5:8000/api/";
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;

    private RetrofitClient(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static synchronized RetrofitClient getInstance(){

        if(retrofitClient==null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;

    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }

}
