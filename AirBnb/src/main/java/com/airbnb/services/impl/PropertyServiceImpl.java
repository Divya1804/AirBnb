package com.airbnb.services.impl;

import com.airbnb.entities.Country;
import com.airbnb.entities.Property;
import com.airbnb.entities.UserAccount;
import com.airbnb.exception.ResourceNotFoundException;
import com.airbnb.repos.CountryRepo;
import com.airbnb.repos.PropertyRepo;
import com.airbnb.repos.UserAccountRepo;
import com.airbnb.services.PropertyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepo propertyRepo;

    @Autowired
    private UserAccountRepo userRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Override
    public Property createProperty(ObjectId userId, ObjectId countryId, Property property) {
        UserAccount user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Account", "ID", userId));
        property.setUser(user);
        Country country = countryRepo.findById(countryId).orElseThrow(() -> new ResourceNotFoundException("Country" , "ID", countryId));
        property.setCountry(country);
        property.setPropertyAddedDate(LocalDateTime.now());
        Property p2 = propertyRepo.insert(property);
        return p2;
    }

    @Override
    public Property updateProperty(Property property, ObjectId id) {
        Property p2 = propertyRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property", "ID", id));
//        p2.setPropertyId(property.getPropertyId());
        p2.setPropertyName(property.getPropertyName());
        p2.setNightlyPrice(property.getNightlyPrice());
        p2.setGuests(property.getGuests());
        p2.setBeds(property.getBeds());
        p2.setBathrooms(property.getBathrooms());
        p2.setDescription(property.getDescription());
        p2.setAddressLine1(property.getAddressLine1());
        p2.setAddressLine2(property.getAddressLine2());
        p2.setPropertyAddedDate(LocalDateTime.now());

        return propertyRepo.save(p2);
    }

    @Override
    public Property getPropertyById(ObjectId id) {
        Property p2 = propertyRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property", "ID", id));
        return p2;
    }

    @Override
    public List<Property> getAllProperties() {
        List<Property> properties = propertyRepo.findAll();
        return properties;
    }

    @Override
    public List<Property> getPropertiesByUserAccount(ObjectId userId) {
        UserAccount user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Account", "ID", userId));
        List<Property> properties = propertyRepo.findPropertiesByUser(user);
        return properties;
    }

    @Override
    public List<Property> getPropertiesByCountry(ObjectId countryId) {
        Country country = countryRepo.findById(countryId).orElseThrow(() -> new ResourceNotFoundException("Country" , "ID", countryId));
        List<Property> properties = propertyRepo.findPropertiesByCountry(country);
        return properties;
    }

    @Override
    public void deleteProperty(ObjectId id) {
        Property p2 = propertyRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property", "ID", id));
        propertyRepo.delete(p2);
    }
}
