package com.unicauca.domain;

public abstract class Handler {

    private Handler nextHandler;
    private String email;

    public Handler(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public abstract boolean attend(Chain request);

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler handler) {
        nextHandler = handler;
    }
}
