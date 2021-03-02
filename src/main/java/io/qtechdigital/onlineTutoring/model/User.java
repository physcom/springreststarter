package io.qtechdigital.onlineTutoring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.qtechdigital.onlineTutoring.model.base.TimedEntity;
import io.qtechdigital.onlineTutoring.model.enums.AuthProvider;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "users")
public class User extends TimedEntity {

    private static final long serialVersionUID = 8126147538659380139L;

    private String firstName;

    private String lastName;

    @Email
    @Column(nullable = false)
    private String email;

    private String imageUrl;

    @Column(nullable = false)
    private Boolean emailVerified = false;

    @JsonIgnore
    private String password;

    private String phone;

    @Column(columnDefinition = "boolean default false")
    private boolean enabled;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "auth_provider")
    private AuthProvider provider;

    private String providerId;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    public User() {

    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
