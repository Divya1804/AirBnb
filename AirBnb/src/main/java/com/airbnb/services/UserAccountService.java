package com.airbnb.services;

import com.airbnb.entities.UserAccount;
import org.bson.types.ObjectId;

public interface UserAccountService {
    public UserAccount createUserAccount(UserAccount user);
    public UserAccount getUserAccountById(ObjectId id);
    public UserAccount updateUserAccount(UserAccount user, ObjectId id);
}
