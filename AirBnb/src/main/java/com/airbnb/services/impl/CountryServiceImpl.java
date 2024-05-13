package com.airbnb.services.impl;

import com.airbnb.entities.Country;
import com.airbnb.exception.ResourceNotFoundException;
import com.airbnb.repos.CountryRepo;
import com.airbnb.services.CountryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo countryRepo;

    @Override
    public Country createCountry(Country country) {
        return countryRepo.save(country);
    }

    @Override
    public Country getCountryById(ObjectId id) {
        return countryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country" , "ID" , id));
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepo.findAll();
    }

    @Override
    public Country updateCountry(Country country, ObjectId id) {
        Country country1 = countryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country", "ID", id));
        country1.setCountryName(country.getCountryName());
        return countryRepo.save(country1);
    }
}
