package com.prjfoody.foody;

import com.prjfoody.foody.domain.Mtm;
import com.prjfoody.foody.domain.Notice;
import com.prjfoody.foody.domain.Product;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.types.Category;
import com.prjfoody.foody.domain.types.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
@RequiredArgsConstructor
public class InitSampleDBSD implements CommandLineRunner {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public void run(String... args) throws Exception {
        suuding();
    }

    public void suuding() {

        Users user1 = new Users();
        user1.initCreateTime();
        user1.setName("김수현");
        user1.setPasswd("1234");
        user1.setTel("1234-5678");
        user1.setEmail("tngus@gmail.com");
        user1.setAddress("서울시");
        user1.setUserType(UserType.ADMIN);

        Users user2 = new Users();
        user2.initCreateTime();
        user2.setName("조승현");
        user2.setPasswd("1234");
        user2.setTel("1234-5678");
        user2.setEmail("tmdgus@gmail.com");
        user2.setAddress("부산시 남구");
        user2.setUserType(UserType.NORMAL);

        Mtm mtm = new Mtm();
        mtm.initStuff(user2);
        mtm.setViewCount(0);
        mtm.setTitle("당장 환불해주세요!!");
        mtm.setContent("먹자마자 쉰내가 나요!! 당장 환불해주세요!!");

        Notice notice1 = new Notice();
        notice1.initStuff(user1);
        notice1.setViewCount(1);
        notice1.setTitle("[제주 한라봉] 인기폭발로 품절되었습니다.");
        notice1.setDescription("한라봉이 인기폭발로 품절되었습니다. 이주 뒤에 좋은 모습으로 찾아오겠습니다");

        Notice notice2 = new Notice();
        notice2.initStuff(user1);
        notice2.setViewCount(1);
        notice2.setTitle("[부산 돼지국밥] 인기폭발로 품절되었습니다.");
        notice2.setDescription("부산 돼지 국밥이 인기폭발로 품절되었습니다. 이주 뒤에 좋은 모습으로 찾아오겠습니다");

        em.persist(user1);
        em.persist(user2);
        em.persist(mtm);
        em.persist(notice1);
        em.persist(notice2);
    }
}
