package com.example.demo.RetrofitService;

import com.example.demo.Dtos.WheatherApiRequest;
import com.example.demo.Dtos.WheatherApiResponse;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
@Service
public class WheatherRetrofit {
    private static final String urlOfWheather = "https://weatherapi-com.p.rapidapi.com";

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder().
            baseUrl(urlOfWheather).
            addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build()).build();


    public WheatherApiResponse actualWeahter(WheatherApiRequest requestDto) throws IOException {

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);     // inicializovanie Retrofitu
        Call<WheatherApiResponse> call = retrofitInterface.getWheather(requestDto.getNameOfCity());   //toto dostanem
        WheatherApiResponse responseDto = call.execute().body();        //vytiahnutie dát z Jasonu
        return responseDto;
    }
}
