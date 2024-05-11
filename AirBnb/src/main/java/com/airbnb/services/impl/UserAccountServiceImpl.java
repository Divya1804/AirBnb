package com.airbnb.services.impl;

import com.airbnb.entities.UserAccount;
import com.airbnb.repos.UserAccountRepo;
import com.airbnb.services.UserAccountService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepo userRepo;

    @Override
    public UserAccount createUserAccount(UserAccount user) {
        user.setJoinedDate(LocalDateTime.now());
        user.setHostStartedDate(null);
        UserAccount account = userRepo.insert(user);
        return account;
    }

    @Override
    public UserAccount getUserAccountById(ObjectId id) {
        Optional<UserAccount> account = userRepo.findById(id);
        if (account.isPresent()){
            UserAccount acc = account.get();
            return acc;
        }
        return null;
    }
}
