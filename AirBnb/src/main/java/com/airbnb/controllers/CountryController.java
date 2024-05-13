package com.airbnb.controllers;

import com.airbnb.entities.Country;
import com.airbnb.services.CountryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country/")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/")
    private ResponseEntity<?> createCountry(@RequestBody Country country){
        return new ResponseEntity<>(countryService.createCountry(country), HttpStatus.CREATED);
    }

    @GetMapping("/")
    private ResponseEntity<?> getAllCountries(){
        return new ResponseEntity<>(countryService.getAllCountries(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getCountryById(@PathVariable ObjectId id){
        return new ResponseEntity<>(countryService.getCountryById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateCountry(@RequestBody Country country, @PathVariable ObjectId id){
        return new ResponseEntity<>(countryService.updateCountry(country, id), HttpStatus.OK);
    }

}
