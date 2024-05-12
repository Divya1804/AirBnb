package com.airbnb.repos;

import com.airbnb.entities.Property;
import com.airbnb.entities.UserAccount;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PropertyRepo extends MongoRepository<Property, ObjectId> {
    public List<Property> findPropertiesByUser(UserAccount user);
}
