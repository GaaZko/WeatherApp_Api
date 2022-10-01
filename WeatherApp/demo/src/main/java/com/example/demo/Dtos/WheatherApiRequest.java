package com.example.demo.Dtos;

public class WheatherApiRequest {
    String q;

    public WheatherApiRequest() {
    }

    public WheatherApiRequest(String q) {
        this.q = q;
    }

    public String getNameOfCity() {
        return q;
    }

}
