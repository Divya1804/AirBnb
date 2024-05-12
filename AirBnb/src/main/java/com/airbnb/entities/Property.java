package com.airbnb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    private ObjectId propertyId;
    private String propertyName;
    private Integer nightlyPrice;
    private Integer guests;
    private Integer beds;
    private Integer bathrooms;
    private String description;
    private String addressLine1;
    private String addressLine2;
    private LocalDateTime propertyAddedDate;

}
