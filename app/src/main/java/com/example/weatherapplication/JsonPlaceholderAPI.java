package com.example.weatherapplication;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceholderAPI {

    @GET("weather")
    Call<Post2> getPosts(
            @Query("q") String city,
            @Query("APPID") String appid,
            @Query("units") String units
    );

}
