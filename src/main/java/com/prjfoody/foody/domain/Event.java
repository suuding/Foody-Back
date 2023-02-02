package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.Stuff;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event extends Stuff {
    @Id
    @GeneratedValue
    @Column(name = "eventId")
    private Long id;
}
