package com.prjfoody.foody.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserImage {
    @Id
    @Column(name = "userImageId")
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private Users user;
    private String userImageUrl;
}
