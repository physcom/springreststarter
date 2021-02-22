package io.qtechdigital.onlineTutoring.components.hateoas;

import io.qtechdigital.onlineTutoring.dto.hateoas.BaseResource;
import io.qtechdigital.onlineTutoring.model.base.BaseEntity;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public abstract class DataTableResourceAssembler<T extends BaseEntity, D extends BaseResource> extends ResourceAssemblerSupport<T, D> {

    public DataTableResourceAssembler(Class<?> controllerClass, Class<D> resourceType) {
        super(controllerClass, resourceType);
    }

    @Override
    protected D createResourceWithId(Object id, T entity) {
        D d = super.createResourceWithId(id, entity);
        d.setBaseId(entity.getId());
        return d;
    }
}
