package com.example.demo.service.crud;

import com.example.demo.exception.NotImplementedException;
import com.example.demo.model.User;
import com.example.demo.model.base.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;

public interface CrudService<E extends BaseEntity> {

    @NotNull
    E save(
            @NotNull E e
    );

    void delete(
            @NotNull E e
    );
}
