package com.spring.weatherapp.controller;

import com.spring.weatherapp.model.City;
import com.spring.weatherapp.model.User;
import com.spring.weatherapp.service.CityService;
import com.spring.weatherapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private UserService userService;
    private CityService cityService;
@Autowired
    public CityController( UserService userService, CityService cityService) {
        this.userService = userService;
        this.cityService = cityService;
    }

    @PostMapping("/add/{userId}")
    public User addFavoriteCity(@RequestBody City city, @PathVariable Long userId) {
        return cityService.addFavoriteCity(city, userId);
    }
    @DeleteMapping("/delete/{userId}/{cityId}")
    public User deleteFavoriteCity(@PathVariable Long cityId, @PathVariable Long userId){
    return cityService.deleteCity(cityId,userId);
    }

    @GetMapping("/{userId}")
    public List<City> getUserFavoriteCities(@PathVariable Long  userId){
    //scriem in city service metoda apoi ne intoarcem
        return cityService.getUserFavoritecities(userId);
    }
}