package com.example.demo.service.impl;

import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByCode("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);

        User registeredUser = userRepository.save(user);

        LOGGER.info("IN register - user: {} successfully registered", registeredUser.getUsername());

        return registeredUser;
    }

    @Override
    public User update(User user, UserUpdateDto userDto) {
        user.setUsername(user.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        if (StringUtils.isEmpty(userDto.getPassword()))
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userDto.getRoleIds().size()!=0){
            List<Role> roles = roleRepository.findAllByIdIn(userDto.getRoleIds());
            user.setRoles(roles);
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
