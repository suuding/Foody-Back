package com.prjfoody.foody.domain.abstracts;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class CreateTime {
    private LocalDateTime firstDateTime;
    private LocalDateTime lastDateTime;

    // 엔티티를 create 하면서 시간을 둘다 초기화 해주는 일이 반복적임 
    public void initCreateTime(){
        this.firstDateTime = LocalDateTime.now();
        this.lastDateTime = LocalDateTime.now();
    }
}
