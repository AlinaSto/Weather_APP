package com.spring.weatherapp.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class CurrentWeatherDTO {
    private String description;
    private Double temperature;
    private Double feelsLikeTemperature;
    private Double windSpeed;
//    private String cityName;
//    private String countryName;
    private LocalDateTime date;

    public CurrentWeatherDTO(String description, Double temperature, Double feelsLikeTemperature, Double windSpeed, LocalDateTime date) {
        this.description = description;
        this.temperature = temperature;
        this.feelsLikeTemperature = feelsLikeTemperature;
        this.windSpeed = windSpeed;
        this.date = date;
    }

    public CurrentWeatherDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public void setFeelsLikeTemperature(Double feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
