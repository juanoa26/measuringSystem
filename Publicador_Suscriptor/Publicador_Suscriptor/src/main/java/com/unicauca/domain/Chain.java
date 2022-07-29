package com.unicauca.domain;

import java.time.LocalDate;

public class Chain {

    private int id;
    private String title;
    private String description;
    private TypeEnum type;
    private final LocalDate date;
    private boolean attended;

    public Chain(int id, String title, String description, TypeEnum type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.attended = false;
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public LocalDate getDate() {
        return date;
    }

}
