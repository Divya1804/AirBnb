package com.airbnb.exception;

import org.bson.types.ObjectId;

public class ResourceNotFoundException extends RuntimeException {

    String resName;
    String fileName;
    ObjectId id;

    public ResourceNotFoundException(String fileName, String resName, ObjectId id) {
        super(String.format("%s not found with %s = %s", fileName, resName, id));
        this.fileName = fileName;
        this.resName = resName;
        this.id = id;
    }
}
