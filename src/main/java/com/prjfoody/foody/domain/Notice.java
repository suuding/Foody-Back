package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.NoticeAndMtm;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Notice extends NoticeAndMtm {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column(columnDefinition="TEXT", nullable = false)
    private String description;
}
