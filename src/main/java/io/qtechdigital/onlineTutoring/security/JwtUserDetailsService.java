package io.qtechdigital.onlineTutoring.security;

import io.qtechdigital.onlineTutoring.repository.UserRepository;
import io.qtechdigital.onlineTutoring.security.jwt.JwtUserFactory;
import io.qtechdigital.onlineTutoring.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final static Logger LOGGER = LoggerFactory.getLogger(JwtUserDetailsService.class);

    private final UserRepository userRepository;

    @Autowired
    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + s + " not found");
        }

        return JwtUserFactory.create(user);
    }
}
