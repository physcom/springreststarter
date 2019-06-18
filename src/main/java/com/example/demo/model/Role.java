package com.example.demo.model;

import com.example.demo.components.Selectable;
import com.example.demo.model.base.TimedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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

    public String getTitle() {
        return title;
    }

    public Role setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Role setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDefaultPage() {
        return defaultPage;
    }

    public Role setDefaultPage(String defaultPage) {
        this.defaultPage = defaultPage;
        return this;
    }

    @Override
    public String getSelectorId() {
        return String.valueOf(getId());
    }

    @Override
    public String getSelectorTitle() {
        return getTitle();
    }
}
