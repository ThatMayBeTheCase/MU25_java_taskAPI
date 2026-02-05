package com.example.taskAPI.model;

public class Task {
    private Integer id;
    private String name;
    private Boolean done;

    public Task() {
    }

    public Task(Integer id, String name, Boolean done) {
        this.id = id;
        this.name = name;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
