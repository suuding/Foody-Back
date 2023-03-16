package com.prjfoody.foody.domain;

import com.prjfoody.foody.domain.abstracts.CreateTime;
import com.prjfoody.foody.domain.types.UserType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Users extends CreateTime {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Long id;
    private String loginId;
    private String name;
    private String passwd;
    private String tel;
    private String email;
    private String address;
    private LocalDate birth;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
