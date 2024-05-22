package com.project.api.controllers;

import com.project.api.entity.ToDoEntity;
import com.project.api.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity createToDo (@RequestBody ToDoEntity todo,
                                      @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(toDoService.createToDo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred!");
        }
    }

    @PutMapping
    public ResponseEntity completeToDo (@RequestParam Long id) {
        try {
            return ResponseEntity.ok(toDoService.completeToDo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred!");
        }
    }
}
