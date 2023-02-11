package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.Stuff;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Event extends Stuff {
    @Id
    @GeneratedValue
    @Column(name = "eventId")
    private Long id;
    private String image;
}
