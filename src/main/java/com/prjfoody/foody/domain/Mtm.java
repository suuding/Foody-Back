package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.NoticeAndMtm;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Getter
@NoArgsConstructor
public class Mtm extends NoticeAndMtm {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=500, nullable=false)
    private String title;

    @Column(columnDefinition="TEXT", nullable = false)
    private String content;

    private Boolean status;
}
