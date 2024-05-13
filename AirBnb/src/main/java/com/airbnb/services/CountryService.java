package com.airbnb.services;

import com.airbnb.entities.Country;
import org.bson.types.ObjectId;
import java.util.List;

public interface CountryService {
    public Country createCountry(Country country);
    public Country getCountryById(ObjectId id);
    public List<Country> getAllCountries();
    public Country updateCountry(Country country, ObjectId id);
}
