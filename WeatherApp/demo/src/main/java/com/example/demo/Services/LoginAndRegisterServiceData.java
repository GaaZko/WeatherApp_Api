package com.example.demo.Services;

import com.example.demo.Model.User;
import com.example.demo.Repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAndRegisterServiceData implements LoginAndRegisterService {


    @Autowired
    public final MainRepository mainRepository;

    public LoginAndRegisterServiceData(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    @Override
    public Boolean login(String username, String password) {
        if (mainRepository.existsByUsername(username) && mainRepository.existsByPassword(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void register(String username, String password) {
        mainRepository.save(new User(username,password));
    }
}
