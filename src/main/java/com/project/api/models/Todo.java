package com.project.api.models;

import com.project.api.entity.ToDoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean isCompleted;

    public static Todo toModel (ToDoEntity entity) {
        Todo model = new Todo ();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }

    public Todo() {

    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public Boolean getCompleted () {
        return isCompleted;
    }

    public void setCompleted (Boolean completed) {
        isCompleted = completed;
    }
}
