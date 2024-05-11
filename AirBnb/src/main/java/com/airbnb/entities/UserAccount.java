package com.airbnb.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "UserAccount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    @Id
//    @Column(name = "user_id")
    private ObjectId id;

//    @Column(name = "first_name")
    private String firstName;

//    @Column(name = "last_name")
    private String lastName;

//    @Column(name = "email_address")
    private String emailAddress;

//    @Column(name = "password")
    private String password;

//    @Column(name = "joined_date")
    private LocalDateTime joinedDate;

//    @Column(name = "host_started_date")
    private LocalDateTime hostStartedDate;
}
