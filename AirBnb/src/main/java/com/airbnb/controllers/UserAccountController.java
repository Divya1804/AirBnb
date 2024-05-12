package com.airbnb.controllers;

import com.airbnb.entities.UserAccount;
import com.airbnb.services.UserAccountService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserAccountController {

    @Autowired
    private UserAccountService userService;

    @PostMapping("/")
    private ResponseEntity<?> createUserAccount(@RequestBody UserAccount user){
        return new ResponseEntity<>(userService.createUserAccount(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getUserAccountById(@PathVariable ObjectId id){
        return new ResponseEntity<>(userService.getUserAccountById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateUserAccount(@RequestBody UserAccount user, @PathVariable ObjectId id){
        return new ResponseEntity<>(userService.updateUserAccount(user,id), HttpStatus.OK);
    }
}
