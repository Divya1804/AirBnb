package com.airbnb.services.impl;

import com.airbnb.entities.UserAccount;
import com.airbnb.exception.ResourceNotFoundException;
import com.airbnb.repos.UserAccountRepo;
import com.airbnb.services.UserAccountService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepo userRepo;

    @Override
    public UserAccount createUserAccount(UserAccount user) {
        user.setJoinedDate(LocalDateTime.now());
        UserAccount account = userRepo.insert(user);
        return account;
    }

    @Override
    public UserAccount getUserAccountById(ObjectId id) {
        UserAccount user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Account", "ID", id));
        return user;
    }

    @Override
    public UserAccount updateUserAccount(UserAccount user, ObjectId id) {
        UserAccount user1 = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Account", "ID", id));
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmailAddress(user.getEmailAddress());
        return userRepo.save(user1);
    }
}
