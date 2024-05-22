package com.project.api.services;

import com.project.api.entity.UserEntity;
import com.project.api.exceptions.UserAlreadyExistException;
import com.project.api.exceptions.UserNotFoundException;
import com.project.api.models.User;
import com.project.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registration (UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User exists already");
        }

        return userRepository.save(user);
    }

    public User getOne (Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User is not founded!");
        }

        return User.toModel(user);
    }

    public Long deleteUser (Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
