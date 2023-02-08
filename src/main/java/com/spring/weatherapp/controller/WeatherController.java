package com.spring.weatherapp.controller;

import com.spring.weatherapp.dto.CurrentWeatherDTO;
import com.spring.weatherapp.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/current")
    public CurrentWeatherDTO getCurrentWeather (@RequestParam(value="city", required = false, defaultValue = "Teheran") String cityName){
        try {
            return weatherService.getCurrentWeather(cityName);
        } catch (IOException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
        }
    }

    @GetMapping("/forecast")
    public List<CurrentWeatherDTO> getForecastWeather (@RequestParam(value="city", required = false, defaultValue = "Teheran") String cityName){
        try {
            return weatherService.getForecastWeather(cityName);
        } catch (IOException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
        }
    }

}