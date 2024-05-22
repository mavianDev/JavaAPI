package com.project.api.services;

import com.project.api.entity.ToDoEntity;
import com.project.api.entity.UserEntity;
import com.project.api.models.Todo;
import com.project.api.repositories.ToDoRepository;
import com.project.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private UserRepository userRepository;

    public Todo createToDo (ToDoEntity todo, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(toDoRepository.save(todo));
    }

    public Todo completeToDo (Long id) {
        ToDoEntity todo = toDoRepository.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(toDoRepository.save(todo));
    }
}
