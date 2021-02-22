package io.qtechdigital.onlineTutoring.dto.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

public class BaseResource extends ResourceSupport implements Serializable {

    @JsonProperty
    public Long id;

    public Long getBaseId() {
        return id;
    }

    public void setBaseId(Long id) {
        this.id = id;
    }
}
