package com.airbnb.services;

import com.airbnb.entities.Property;
import com.airbnb.entities.UserAccount;
import org.bson.types.ObjectId;
import java.util.List;

public interface PropertyService {
    public Property createProperty(ObjectId userId, ObjectId countryId, Property property);
    public Property updateProperty(Property property, ObjectId id);
    public Property getPropertyById(ObjectId id);
    public List<Property> getAllProperties();
    public List<Property> getPropertiesByUserAccount(ObjectId userId);
    public List<Property> getPropertiesByCountry(ObjectId countryId);
    public void deleteProperty(ObjectId id);
}
