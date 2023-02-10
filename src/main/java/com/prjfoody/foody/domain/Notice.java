package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.NoticeAndMtm;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Notice extends NoticeAndMtm {

    @Id @GeneratedValue
    private Long id;
}
