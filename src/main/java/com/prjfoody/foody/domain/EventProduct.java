package com.prjfoody.foody.domain;

import javax.persistence.*;

@Entity
public class EventProduct {
    @Id
    @Column(name = "eventProductId")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventId")
    private Event event;
}
