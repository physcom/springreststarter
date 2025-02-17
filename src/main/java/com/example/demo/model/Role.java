package com.example.demo.model;

import com.example.demo.components.Selectable;
import com.example.demo.model.base.TimedEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role extends TimedEntity implements Selectable {

    @Override
    public void prePersist() {
        super.prePersist();
    }

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String code;

    private String defaultPage;

    @Override
    public String getSelectorId() {
        return String.valueOf(getId());
    }

    @Override
    public String getSelectorTitle() {
        return getTitle();
    }
}
