package com.example.demo.Controllers;

import com.example.demo.Dtos.WheatherApiRequest;
import com.example.demo.Dtos.WheatherApiResponse;
import com.example.demo.RetrofitService.WheatherRetrofit;
import com.example.demo.Services.LoginAndRegisterService;
import com.example.demo.Services.StoreDataInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;

@Controller
public class MainController {
    @Autowired
    public final LoginAndRegisterService loginAndRegisterService;
    public final StoreDataInt storeDataInt;

    public final WheatherRetrofit wheatherRetrofit;




    public MainController(LoginAndRegisterService loginAndRegisterService, StoreDataInt storeDataInt, WheatherRetrofit wheatherRetrofit) {
        this.loginAndRegisterService = loginAndRegisterService;
        this.storeDataInt = storeDataInt;

        this.wheatherRetrofit = wheatherRetrofit;
    }


    @GetMapping("/")
    public String renderMainPage() {
        return "index";
    }

    @PostMapping("/login")
    public String loginPage(@RequestParam String name, @RequestParam String password) {
        if (loginAndRegisterService.login(name, password)) {
            return "myPage";
        } else return "registerPage";
    }

    @GetMapping("/registerPage")
    public String renderRegisterPage() {
        return "registerPage";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String password) {
        loginAndRegisterService.register(name, password);
        return "myPage";
    }



    @PostMapping ("/findCity")
    public String findACurrentTempInCity(@RequestParam(value = "q") String q, Model model) throws IOException {
        WheatherApiRequest request = new WheatherApiRequest(q);
        WheatherApiResponse response = wheatherRetrofit.actualWeahter(request);
        model.addAttribute("temperature",response.getCurrent().getTemp_c());
        storeDataInt.store(response);
        return "myPage";
    }



    //ResponseEntity<? extends ResponseDto>  ; new ResponseEntity<>(response, HttpStatus.ACCEPTED)
}
