package com.prjfoody.foody.domain.abstracts;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.prjfoody.foody.domain.Users;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class Stuff extends CreateTime {

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users owner;
    private String title;
    private String description;
    private Boolean lock;
    private Boolean delete;

    // 프론트에서 넘어오지 않는 값들을 초기화 해주는 메소드
    public void initStuff(Users user){
        this.owner = user;
        this.lock = false;
        this.delete = false;
        this.setFirstDateTime(LocalDateTime.now());
        this.setLastDateTime(LocalDateTime.now());
    }
}
