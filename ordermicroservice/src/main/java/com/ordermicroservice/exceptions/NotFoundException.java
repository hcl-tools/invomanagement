package com.ordermicroservice.exceptions;

import java.util.function.Supplier;

public class NotFoundException extends Exception{

    String objectName;
    int id;

    public NotFoundException(String objectName, int id) {
        super("Could not find: " + objectName + ", ID: " + id);
        this.objectName = objectName;
        this.id = id;
    }

}
