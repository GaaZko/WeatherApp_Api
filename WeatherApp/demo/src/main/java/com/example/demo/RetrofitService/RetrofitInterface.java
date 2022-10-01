package com.example.demo.RetrofitService;


import com.example.demo.Dtos.WheatherApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("/current.json")
    @Headers({
            "X-RapidAPI-Key: 710bb4956amshae02f427f746ca6p1d2db1jsn1cce4096f0ee",
            "X-RapidAPI-Host: weatherapi-com.p.rapidapi.com"
    })
    public Call <WheatherApiResponse> getWheather(@Query("q") String q);
}
