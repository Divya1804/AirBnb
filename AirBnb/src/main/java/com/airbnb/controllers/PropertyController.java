package com.airbnb.controllers;

import com.airbnb.entities.Property;
import com.airbnb.services.PropertyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/property/")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/{id}")
    private ResponseEntity<?> getPropertyById(@PathVariable ObjectId id){
        return new ResponseEntity<>(propertyService.getPropertyById(id), HttpStatus.OK);
    }

    @PostMapping("/{userId}/{countryId}/")
    private ResponseEntity<?> createProperty(@PathVariable ObjectId userId, @PathVariable ObjectId countryId,@RequestBody Property property){
        return new ResponseEntity<>(propertyService.createProperty(userId,countryId,property),HttpStatus.CREATED);
    }

    @GetMapping("/")
    private ResponseEntity<?> getAllProperties(){
        return new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/")
    private ResponseEntity<?> getPropertiesByUserAccount(@PathVariable("userId") ObjectId userId){
        return new ResponseEntity<>(propertyService.getPropertiesByUserAccount(userId), HttpStatus.OK);
    }

    @GetMapping("/country/{countryId}/")
    private ResponseEntity<?> getPropertiesByCountry(@PathVariable("countryId") ObjectId countryId){
        return new ResponseEntity<>(propertyService.getPropertiesByCountry(countryId),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteProperty(@PathVariable ObjectId id){
        propertyService.deleteProperty(id);
        return new ResponseEntity<>("Property deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateProperty(@RequestBody Property property, @PathVariable ObjectId id){
        return new ResponseEntity<>(propertyService.updateProperty(property, id), HttpStatus.OK);
    }
}
