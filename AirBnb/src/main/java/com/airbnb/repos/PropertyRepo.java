package com.airbnb.repos;

import com.airbnb.entities.Property;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PropertyRepo extends MongoRepository<Property, ObjectId> {
}
