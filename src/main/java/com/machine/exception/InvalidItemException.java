package com.machine.exception;

public class InvalidItemException extends IllegalArgumentException {
    private String message;

    public InvalidItemException(String string) {
        this.message = string;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
