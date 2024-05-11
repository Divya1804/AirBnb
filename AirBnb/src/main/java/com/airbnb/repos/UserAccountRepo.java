package com.airbnb.repos;

import com.airbnb.entities.UserAccount;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAccountRepo extends MongoRepository<UserAccount, ObjectId> {
}
