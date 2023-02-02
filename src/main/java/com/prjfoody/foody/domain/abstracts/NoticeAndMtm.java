package com.prjfoody.foody.domain.abstracts;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class NoticeAndMtm extends Stuff {
    private Integer viewCount;
}
