package com.example.demo.Services;

public interface LoginAndRegisterService {
    Boolean login(String username, String password);
    void register(String username, String password);
}
