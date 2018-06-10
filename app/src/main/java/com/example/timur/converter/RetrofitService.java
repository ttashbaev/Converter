package com.example.timur.converter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Timur on 17.03.2018.
 */

public interface RetrofitService {
    @GET("latest")
    Call<CurrencyModel> getJSONList();

}
