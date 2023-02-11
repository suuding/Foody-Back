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
        init();
        suuding();
    }

    public void init(){
        System.out.println("InitSampleDB.init");

        Users users = new Users();
        users.initCreateTime();
        users.setName("푸디");
        users.setPasswd("1234");
        users.setTel("1234-5678");
        users.setEmail("abcd@gmail.com");
        users.setAddress("부산시 남구");
        users.setUserType(UserType.ADMIN);


        Product product = new Product();
        product.initStuff(users);
        product.setPrice(10000);
        product.setSalePrice(7000);
        product.calcSaleRate();
        product.setSaleStatus(true);
        product.setQuantity(100);
        product.setCategory(Category.MEAT);
        product.setGrade(8);

        em.persist(users);
        em.persist(product);
    }

    public void suuding() {

        Users user = new Users();
        user.initCreateTime();
        user.setName("김수현");
        user.setPasswd("1234");
        user.setTel("1234-5678");
        user.setEmail("tngus@gmail.com");
        user.setAddress("서울시");
        user.setUserType(UserType.ADMIN);

        Mtm mtm = new Mtm();
        mtm.initStuff(user);
        mtm.setViewCount(0);
        mtm.setTitle("당장 환불해주세요!!");
        mtm.setContent("먹자마자 쉰내가 나요!! 당장 환불해주세요!!");

        Notice notice1 = new Notice();
        notice1.initStuff(user);
        notice1.setViewCount(1);
        notice1.setTitle("[제주 한라봉] 인기폭발로 품절되었습니다.");
        notice1.setDescription("한라봉이 인기폭발로 품절되었습니다. 이주 뒤에 좋은 모습으로 찾아오겠습니다");

        Notice notice2 = new Notice();
        notice2.initStuff(user);
        notice2.setViewCount(1);
        notice2.setTitle("[부산 돼지국밥] 인기폭발로 품절되었습니다.");
        notice2.setDescription("부산 돼지 국밥이 인기폭발로 품절되었습니다. 이주 뒤에 좋은 모습으로 찾아오겠습니다");

        em.persist(user);
        em.persist(mtm);
        em.persist(notice1);
        em.persist(notice2);
    }
}
