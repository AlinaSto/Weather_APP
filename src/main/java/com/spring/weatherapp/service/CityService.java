package com.spring.weatherapp.service;

import com.spring.weatherapp.model.City;
import com.spring.weatherapp.model.User;
import com.spring.weatherapp.repository.CityRepository;
import com.spring.weatherapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CityService {
    private UserRepository userRepository;
    private CityRepository cityRepository;

    public CityService(@Autowired UserRepository userRepository, @Autowired CityRepository cityRepository) {
        this.userRepository = userRepository;
        this.cityRepository = cityRepository;
    }

    public User addFavoriteCity(City city, Long userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        foundUser.getCityList().add(city);
        city.getUserList().add(foundUser);
        //salvam user dupa modificarile facute
        return userRepository.save(foundUser);
    }

    public User deleteCity(Long cityId, Long userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        City foundCity = cityRepository.findById(cityId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        foundUser.getCityList().remove(foundCity);
        foundCity.getUserList().remove(foundUser);
        return userRepository.save(foundUser);
    }

    public List<City> getUserFavoritecities(Long userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        return cityRepository.findAllByUserListContaining(foundUser);
    }
}
