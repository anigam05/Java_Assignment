package com.example.custom.exceptions;

public class UndefinedCategoryException extends Exception {

    private static final long serialVersionUID = 391255771141182500L;
    String message;

    public UndefinedCategoryException(String message) {
        super();
        this.message = message;
        System.out.println(message);
    }
    
}
