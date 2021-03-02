package io.qtechdigital.onlineTutoring.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

/**
 * Spring Security wrapper for class .
 */

public class JwtUser implements OAuth2User, UserDetails {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final boolean enabled;
    private Map<String, Object> attributes;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Long id,
                   String firstName,
                   String lastName,
                   String password,
                   String email,
                   boolean enabled,
                   Collection<? extends GrantedAuthority> authorities
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }
}
