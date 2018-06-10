package com.example.timur.converter;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Timur on 17.03.2018.
 */

public class StartApplication extends Application {
    private final String BASE_URL = "https://api.fixer.io";
    private RetrofitService service;

    @Override
    public void onCreate() {
        super.onCreate();
        service = initRetrofit();
    }

    public static StartApplication get (Context context) {
        return (StartApplication) context.getApplicationContext();
    }

    public RetrofitService getRetrofit(){
        return service;
    }

    private RetrofitService initRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService.class);
    }

    private OkHttpClient okHttpClient () {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS )
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
