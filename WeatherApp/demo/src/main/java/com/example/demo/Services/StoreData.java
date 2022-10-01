package com.example.demo.Services;

import com.example.demo.Dtos.WheatherApiResponse;
import com.example.demo.Model.StoreTemp;
import com.example.demo.Repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreData implements StoreDataInt {

    @Autowired
    public final TemperatureRepository temperatureRepository;

    public StoreData(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    @Override
    public void store(WheatherApiResponse wheatherApiResponse) {
        String temperature1 = wheatherApiResponse.getCurrent().getTemp_c();
        //Integer temperature = Integer.valueOf(temperature1);
        temperatureRepository.save(new StoreTemp(temperature1));
    }
}
