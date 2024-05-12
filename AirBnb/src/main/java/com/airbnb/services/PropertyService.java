package com.airbnb.services;

import com.airbnb.entities.Property;
import org.bson.types.ObjectId;
import java.util.List;

public interface PropertyService {
    public Property createProperty(Property property);
    public Property updateProperty(Property property, ObjectId id);
    public Property getPropertyById(ObjectId id);
    public List<Property> getAllProperties();
    public void deleteProperty(ObjectId id);
}
