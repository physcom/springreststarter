package com.example.demo.service.crud;

import com.example.demo.model.base.BaseEntity;

import javax.validation.constraints.NotNull;

public interface FormCrudService<F, E extends BaseEntity> extends CrudService<E> {

    E create(
            @NotNull F f
    );

    E update(
            @NotNull F f,
            @NotNull E e
    );

}