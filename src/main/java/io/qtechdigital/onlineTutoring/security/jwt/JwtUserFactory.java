package io.qtechdigital.onlineTutoring.security.jwt;

import io.qtechdigital.onlineTutoring.model.Role;
import io.qtechdigital.onlineTutoring.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of Factory Method for class {@link JwtUser}.
 */
public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {

        return new JwtUser(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                user.isEnabled(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))

        );
    }

    public static OAuth2User create(User user, Map<String, Object> attributes) {

        List<GrantedAuthority> authorities = Collections.
                singletonList(new SimpleGrantedAuthority("ROLE_OAUTH2_USER"));

        JwtUser jwtUser = new JwtUser(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                user.isEnabled(),
                authorities

        );

        jwtUser.setAttributes(attributes);

        return jwtUser;
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getCode())
                ).collect(Collectors.toList());
    }


}
