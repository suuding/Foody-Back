package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.NoticeAndMtm;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Mtm extends NoticeAndMtm {
    @Id @GeneratedValue
    @Column(name = "mtmId")
    private Long id;
}
