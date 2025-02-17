package com.example.demo.service;

import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    User update(User user, UserUpdateDto userDto);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    boolean existByUsername(String username);

    boolean existByEmail(String username);

    void delete(Long id);
}
