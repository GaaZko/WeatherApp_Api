package com.example.demo.Dtos;

public class WheatherApiResponse implements ResponseDto {

    Current current;

    public WheatherApiResponse(Current current) {
        this.current = current;
    }

    public Current getCurrent() {
        return current;
    }
}
