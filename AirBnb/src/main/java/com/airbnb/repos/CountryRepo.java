package com.airbnb.repos;

import com.airbnb.entities.Country;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepo extends MongoRepository<Country, ObjectId> {

}
