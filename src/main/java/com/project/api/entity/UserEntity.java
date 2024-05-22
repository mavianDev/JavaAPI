package com.project.api.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
    private ArrayList<ToDoEntity> todos;

    public UserEntity () {
        
    }

    public Long getId() {
        return id;
    }

    public ArrayList<ToDoEntity> getTodos () {
        return todos;
    }

    public void setTodos (ArrayList<ToDoEntity> todos) {
        this.todos = todos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
