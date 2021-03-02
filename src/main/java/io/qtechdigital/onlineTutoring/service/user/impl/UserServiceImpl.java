package io.qtechdigital.onlineTutoring.service.user.impl;

import io.qtechdigital.onlineTutoring.repository.UserRepository;
import io.qtechdigital.onlineTutoring.dto.user.request.UserUpdateDto;
import io.qtechdigital.onlineTutoring.model.User;
import io.qtechdigital.onlineTutoring.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User registeredUser = userRepository.save(user);

        LOGGER.info("IN register - user: {} successfully registered", registeredUser.getEmail());

        return registeredUser;
    }

    @Override
    public User update(User user, UserUpdateDto userDto) {

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        if (StringUtils.isEmpty(userDto.getPassword()))
            user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
