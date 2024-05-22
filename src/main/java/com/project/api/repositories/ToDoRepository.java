package com.project.api.repositories;

import com.project.api.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository <ToDoEntity, Long> {
}
