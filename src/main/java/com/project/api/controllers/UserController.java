package com.project.api.controllers;

import com.project.api.entity.UserEntity;
import com.project.api.exceptions.UserAlreadyExistException;
import com.project.api.exceptions.UserNotFoundException;
import com.project.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity <String> registration (@RequestBody UserEntity user) {
        try {
            userService.registration (user);
            return ResponseEntity.ok("User saved!");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred!");
        }
    }

    @GetMapping
    public ResponseEntity getOneUser (@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred!");
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity deleteUser (@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error occurred!");
        }
    }
}
