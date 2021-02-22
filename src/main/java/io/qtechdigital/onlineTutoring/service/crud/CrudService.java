package io.qtechdigital.onlineTutoring.service.crud;

import io.qtechdigital.onlineTutoring.model.base.BaseEntity;

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
