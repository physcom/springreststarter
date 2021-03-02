package io.qtechdigital.onlineTutoring.security.jwt;

import io.qtechdigital.onlineTutoring.exception.ResourceNotFoundException;
import io.qtechdigital.onlineTutoring.repository.UserRepository;
import io.qtechdigital.onlineTutoring.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

        Optional<User> user = userRepository.findByEmail(s);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User with username: " + s + " not found");
        }

        LOGGER.info("user loaded: {}", user.get().getEmail());
        return JwtUserFactory.create(user.get());
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        return JwtUserFactory.create(user);
    }
}
