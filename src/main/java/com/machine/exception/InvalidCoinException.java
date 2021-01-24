package com.machine.exception;

public class InvalidCoinException extends IllegalArgumentException {
    private String message;

    public InvalidCoinException(String string) {
        this.message = string;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
