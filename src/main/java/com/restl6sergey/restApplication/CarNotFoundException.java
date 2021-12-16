package com.restl6sergey.restApplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException{

    private String id;

    public CarNotFoundException(String id) {
        super(String.format(" not found : '%s'",id));
        this.id=id;

    }

    public String getCarId() {
        return this.id;
    }

}