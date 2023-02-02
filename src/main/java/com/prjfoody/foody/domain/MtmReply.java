package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.NoticeAndMtm;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MtmReply extends NoticeAndMtm {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mtmId")
    private Mtm mtm;
}
