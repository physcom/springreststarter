package com.example.demo.service.crud;

import com.example.demo.model.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;

public abstract class AbstractCrudService<F, E extends BaseEntity> implements FormCrudService<F, E> {

    protected final JpaRepository<E, Long> repository;

    protected AbstractCrudService(JpaRepository<E, Long> repository) {
        this.repository = repository;
    }

    @NotNull
    @Override
    public E save(@NotNull E e) {
        return repository.save(e);
    }

    @Override
    public void delete(@NotNull E e) {
        repository.delete(e);
    }

}
