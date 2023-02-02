package com.prjfoody.foody.domain.abstracts;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class EventProducts extends Products {
    private Long productId;
    private Long eventId;
}
