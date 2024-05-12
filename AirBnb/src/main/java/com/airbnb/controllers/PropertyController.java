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

    @PostMapping("/")
    private ResponseEntity<?> createProperty(@RequestBody Property property){
        return new ResponseEntity<>(propertyService.createProperty(property),HttpStatus.CREATED);
    }

    @GetMapping("/")
    private ResponseEntity<?> getAllProperties(){
        return new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
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
