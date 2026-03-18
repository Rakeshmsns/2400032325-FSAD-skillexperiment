package com.klu.service;

import com.klu.model.User;
import com.klu.repository.UserRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(@NonNull User user) {
        return userRepository.save(user);
    }

    @Nullable
    public User login(@NonNull String email, @NonNull String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
