package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.CreateTime;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Orders extends CreateTime {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users users;


}
