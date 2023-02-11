package com.prjfoody.foody;

import com.prjfoody.foody.domain.Event;
import com.prjfoody.foody.domain.Product;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.types.Category;
import com.prjfoody.foody.domain.types.UserType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class InitSampleDB implements CommandLineRunner {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public void run(String... args) throws Exception {
        init();
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

        List<Product> productList = new ArrayList<>();

        Product p1 = new Product();
        p1.setTitle("[Foody] 오렌지");
        p1.initStuff(users);
        p1.setPrice(5000);
        p1.setSalePrice(3000);
        p1.calcSaleRate();
        p1.setSaleStatus(true);
        p1.setQuantity(100);
        p1.setCategory(Category.VEGETABLE);
        p1.setGrade(8);
        productList.add(p1);

        Product p2 = new Product();
        p2.setTitle("[Foody] 라임");
        p2.initStuff(users);
        p2.setPrice(6000);
        p2.setSalePrice(4000);
        p2.calcSaleRate();
        p2.setSaleStatus(true);
        p2.setQuantity(100);
        p2.setCategory(Category.VEGETABLE);
        p2.setGrade(8);
        productList.add(p2);

        Product p3 = new Product();
        p3.setTitle("[Foody] 참외");
        p3.initStuff(users);
        p3.setPrice(3000);
        p3.setSalePrice(2800);
        p3.calcSaleRate();
        p3.setSaleStatus(true);
        p3.setQuantity(100);
        p3.setCategory(Category.VEGETABLE);
        p3.setGrade(8);
        productList.add(p3);

        Product p4 = new Product();
        p4.setTitle("[Foody] 귤");
        p4.initStuff(users);
        p4.setPrice(6000);
        p4.setSalePrice(4000);
        p4.calcSaleRate();
        p4.setSaleStatus(true);
        p4.setQuantity(100);
        p4.setCategory(Category.VEGETABLE);
        p4.setGrade(8);
        productList.add(p4);

        Product p5 = new Product();
        p5.setTitle("[Foody] 오렌지 소형");
        p5.initStuff(users);
        p5.setPrice(4000);
        p5.setSalePrice(3500);
        p5.calcSaleRate();
        p5.setSaleStatus(true);
        p5.setQuantity(100);
        p5.setCategory(Category.VEGETABLE);
        p5.setGrade(8);
        productList.add(p5);

        Product p6 = new Product();
        p6.setTitle("[Foody] 블루베리 봉지");
        p6.initStuff(users);
        p6.setPrice(10000);
        p6.setSalePrice(9000);
        p6.calcSaleRate();
        p6.setSaleStatus(true);
        p6.setQuantity(100);
        p6.setCategory(Category.VEGETABLE);
        p6.setGrade(8);
        productList.add(p6);

        Product p7 = new Product();
        p7.setTitle("[Foody] 블루베리");
        p7.initStuff(users);
        p7.setPrice(6800);
        p7.setSalePrice(6000);
        p7.calcSaleRate();
        p7.setSaleStatus(true);
        p7.setQuantity(100);
        p7.setCategory(Category.VEGETABLE);
        p7.setGrade(8);
        productList.add(p7);

        Product p8 = new Product();
        p8.setTitle("[Foody] 오렌지 대형");
        p8.initStuff(users);
        p8.setPrice(10000);
        p8.setSalePrice(9000);
        p8.calcSaleRate();
        p8.setSaleStatus(true);
        p8.setQuantity(100);
        p8.setCategory(Category.VEGETABLE);
        p8.setGrade(8);
        productList.add(p8);

        Product p9 = new Product();
        p9.setTitle("[Foody] 망고");
        p9.initStuff(users);
        p9.setPrice(3000);
        p9.setSalePrice(2600);
        p9.calcSaleRate();
        p9.setSaleStatus(true);
        p9.setQuantity(100);
        p9.setCategory(Category.VEGETABLE);
        p9.setGrade(8);
        productList.add(p9);

        Product p10 = new Product();
        p10.setTitle("[Foody] 과수원 사과");
        p10.initStuff(users);
        p10.setPrice(4300);
        p10.setSalePrice(4000);
        p10.calcSaleRate();
        p10.setSaleStatus(true);
        p10.setQuantity(100);
        p10.setCategory(Category.VEGETABLE);
        p10.setGrade(8);
        productList.add(p10);

        Product p11 = new Product();
        p11.setTitle("[Foody] 명태 알포");
        p11.initStuff(users);
        p11.setPrice(10000);
        p11.setSalePrice(9000);
        p11.calcSaleRate();
        p11.setSaleStatus(true);
        p11.setQuantity(100);
        p11.setCategory(Category.FISH);
        p11.setGrade(8);
        productList.add(p11);

        Product p12 = new Product();
        p12.setTitle("[Foody] 랍스타 바스켓");
        p12.initStuff(users);
        p12.setPrice(15000);
        p12.setSalePrice(13800);
        p12.calcSaleRate();
        p12.setSaleStatus(true);
        p12.setQuantity(100);
        p12.setCategory(Category.FISH);
        p12.setGrade(8);
        productList.add(p12);

        Product p13 = new Product();
        p13.setTitle("[Foody] 랍스타 바스켓");
        p13.initStuff(users);
        p13.setPrice(10000);
        p13.setSalePrice(9000);
        p13.calcSaleRate();
        p13.setSaleStatus(true);
        p13.setQuantity(100);
        p13.setCategory(Category.FISH);
        p13.setGrade(8);
        productList.add(p13);

        Product p14 = new Product();
        p14.setTitle("[Foody] 문어 슬라이스");
        p14.initStuff(users);
        p14.setPrice(10000);
        p14.setSalePrice(9000);
        p14.calcSaleRate();
        p14.setSaleStatus(true);
        p14.setQuantity(100);
        p14.setCategory(Category.FISH);
        p14.setGrade(8);
        productList.add(p14);

        Product p15 = new Product();
        p15.setTitle("[Foody] 딱 새우회 150g");
        p15.initStuff(users);
        p15.setPrice(6800);
        p15.setSalePrice(6000);
        p15.calcSaleRate();
        p15.setSaleStatus(true);
        p15.setQuantity(100);
        p15.setCategory(Category.FISH);
        p15.setGrade(8);
        productList.add(p15);

        Product p16 = new Product();
        p16.setTitle("[Foody] 딱 새우회 300g");
        p16.initStuff(users);
        p16.setPrice(13600);
        p16.setSalePrice(11000);
        p16.calcSaleRate();
        p16.setSaleStatus(true);
        p16.setQuantity(100);
        p16.setCategory(Category.FISH);
        p16.setGrade(8);
        productList.add(p16);

        Product p17 = new Product();
        p17.setTitle("[Foody] 제주 고등어살 소형");
        p17.initStuff(users);
        p17.setPrice(4200);
        p17.setSalePrice(3800);
        p17.calcSaleRate();
        p17.setSaleStatus(true);
        p17.setQuantity(100);
        p17.setCategory(Category.FISH);
        p17.setGrade(8);
        productList.add(p17);

        Product p18 = new Product();
        p18.setTitle("[Foody] 자숙 문어");
        p18.initStuff(users);
        p18.setPrice(17800);
        p18.setSalePrice(14500);
        p18.calcSaleRate();
        p18.setSaleStatus(true);
        p18.setQuantity(100);
        p18.setCategory(Category.FISH);
        p18.setGrade(8);
        productList.add(p18);

        Product p19 = new Product();
        p19.setTitle("[Foody] 제주 고등어살 대형");
        p19.initStuff(users);
        p19.setPrice(12800);
        p19.setSalePrice(11000);
        p19.calcSaleRate();
        p19.setSaleStatus(true);
        p19.setQuantity(100);
        p19.setCategory(Category.FISH);
        p19.setGrade(8);
        productList.add(p19);

        Product p20 = new Product();
        p20.setTitle("[Foody] 냉동 갈치");
        p20.initStuff(users);
        p20.setPrice(18500);
        p20.setSalePrice(16650);
        p20.calcSaleRate();
        p20.setSaleStatus(true);
        p20.setQuantity(100);
        p20.setCategory(Category.FISH);
        p20.setGrade(8);
        productList.add(p20);

        Product p21 = new Product();
        p21.setTitle("[Foody] 앞다리살 불고기");
        p21.initStuff(users);
        p21.setPrice(7200);
        p21.setSalePrice(6900);
        p21.calcSaleRate();
        p21.setSaleStatus(true);
        p21.setQuantity(100);
        p21.setCategory(Category.MEAT);
        p21.setGrade(8);
        productList.add(p21);

        Product p22 = new Product();
        p22.setTitle("[Foody] 꽃갈비살");
        p22.initStuff(users);
        p22.setPrice(7200);
        p22.setSalePrice(6900);
        p22.calcSaleRate();
        p22.setSaleStatus(true);
        p22.setQuantity(100);
        p22.setCategory(Category.MEAT);
        p22.setGrade(8);
        productList.add(p22);

        Product p23 = new Product();
        p23.setTitle("[Foody] 국거리용 한우");
        p23.initStuff(users);
        p23.setPrice(15000);
        p23.setSalePrice(14000);
        p23.calcSaleRate();
        p23.setSaleStatus(true);
        p23.setQuantity(100);
        p23.setCategory(Category.MEAT);
        p23.setGrade(8);
        productList.add(p23);

        Product p24 = new Product();
        p24.setTitle("[Foody] 앞다리살 불고기");
        p24.initStuff(users);
        p24.setPrice(7200);
        p24.setSalePrice(6900);
        p24.calcSaleRate();
        p24.setSaleStatus(true);
        p24.setQuantity(100);
        p24.setCategory(Category.MEAT);
        p24.setGrade(8);
        productList.add(p24);

        Product p25 = new Product();
        p25.setTitle("[Foody] 한우 양지 국거리용");
        p25.initStuff(users);
        p25.setPrice(16800);
        p25.setSalePrice(15000);
        p25.calcSaleRate();
        p25.setSaleStatus(true);
        p25.setQuantity(100);
        p25.setCategory(Category.MEAT);
        p25.setGrade(8);
        productList.add(p25);

        Product p26 = new Product();
        p26.setTitle("[Foody] 갈비 찜용");
        p26.initStuff(users);
        p26.setPrice(25000);
        p26.setSalePrice(23000);
        p26.calcSaleRate();
        p26.setSaleStatus(true);
        p26.setQuantity(100);
        p26.setCategory(Category.MEAT);
        p26.setGrade(8);
        productList.add(p26);

        Product p27 = new Product();
        p27.setTitle("[Foody] 한돈 등심 탕수육용");
        p27.initStuff(users);
        p27.setPrice(12000);
        p27.setSalePrice(9900);
        p27.calcSaleRate();
        p27.setSaleStatus(true);
        p27.setQuantity(100);
        p27.setCategory(Category.MEAT);
        p27.setGrade(8);
        productList.add(p27);

        Product p28 = new Product();
        p28.setTitle("[Foody] 소고기 양지 국거리용");
        p28.initStuff(users);
        p28.setPrice(12000);
        p28.setSalePrice(9900);
        p28.calcSaleRate();
        p28.setSaleStatus(true);
        p28.setQuantity(100);
        p28.setCategory(Category.MEAT);
        p28.setGrade(8);
        productList.add(p28);

        Product p29 = new Product();
        p29.setTitle("[Foody] 이베리코 목심");
        p29.initStuff(users);
        p29.setPrice(7200);
        p29.setSalePrice(6900);
        p29.calcSaleRate();
        p29.setSaleStatus(true);
        p29.setQuantity(100);
        p29.setCategory(Category.MEAT);
        p29.setGrade(8);
        productList.add(p29);

        Product p30 = new Product();
        p30.setTitle("[Foody] 한우 양지 국거리용");
        p30.initStuff(users);
        p30.setPrice(23000);
        p30.setSalePrice(19900);
        p30.calcSaleRate();
        p30.setSaleStatus(true);
        p30.setQuantity(100);
        p30.setCategory(Category.MEAT);
        p30.setGrade(8);
        productList.add(p30);

        Product p31 = new Product();
        p31.setTitle("[Foody] 유기농 삶은 시래기");
        p31.initStuff(users);
        p31.setPrice(3490);
        p31.setSalePrice(3000);
        p31.calcSaleRate();
        p31.setSaleStatus(true);
        p31.setQuantity(100);
        p31.setCategory(Category.INSTANT);
        p31.setGrade(8);
        productList.add(p31);

        Product p32 = new Product();
        p32.setTitle("[Foody] 자연방목 아기치즈");
        p32.initStuff(users);
        p32.setPrice(5400);
        p32.setSalePrice(4900);
        p32.calcSaleRate();
        p32.setSaleStatus(true);
        p32.setQuantity(100);
        p32.setCategory(Category.INSTANT);
        p32.setGrade(8);
        productList.add(p32);

        Product p33 = new Product();
        p33.setTitle("[Foody] 유기농 발아 보리 차");
        p33.initStuff(users);
        p33.setPrice(7000);
        p33.setSalePrice(6500);
        p33.calcSaleRate();
        p33.setSaleStatus(true);
        p33.setQuantity(100);
        p33.setCategory(Category.INSTANT);
        p33.setGrade(8);
        productList.add(p33);

        Product p34 = new Product();
        p34.setTitle("[Foody] 아기상어 유기농 쌀과자");
        p34.initStuff(users);
        p34.setPrice(4000);
        p34.setSalePrice(3300);
        p34.calcSaleRate();
        p34.setSaleStatus(true);
        p34.setQuantity(100);
        p34.setCategory(Category.INSTANT);
        p34.setGrade(8);
        productList.add(p34);

        Product p35 = new Product();
        p35.setTitle("[Foody] 오가닉 딸기컵");
        p35.initStuff(users);
        p35.setPrice(6200);
        p35.setSalePrice(6000);
        p35.calcSaleRate();
        p35.setSaleStatus(true);
        p35.setQuantity(100);
        p35.setCategory(Category.INSTANT);
        p35.setGrade(8);
        productList.add(p35);

        Product p36 = new Product();
        p36.setTitle("[Foody] 유기농 알로에");
        p36.initStuff(users);
        p36.setPrice(12500);
        p36.setSalePrice(11900);
        p36.calcSaleRate();
        p36.setSaleStatus(true);
        p36.setQuantity(100);
        p36.setCategory(Category.INSTANT);
        p36.setGrade(8);
        productList.add(p36);

        Product p37 = new Product();
        p37.setTitle("[Foody] 얼려먹는 아이스 쥬스");
        p37.initStuff(users);
        p37.setPrice(6800);
        p37.setSalePrice(5900);
        p37.calcSaleRate();
        p37.setSaleStatus(true);
        p37.setQuantity(100);
        p37.setCategory(Category.INSTANT);
        p37.setGrade(8);
        productList.add(p37);

        Product p38 = new Product();
        p38.setTitle("[Foody] 유기농 벌과자");
        p38.initStuff(users);
        p38.setPrice(3500);
        p38.setSalePrice(2800);
        p38.calcSaleRate();
        p38.setSaleStatus(true);
        p38.setQuantity(100);
        p38.setCategory(Category.INSTANT);
        p38.setGrade(8);
        productList.add(p38);

        Product p39 = new Product();
        p39.setTitle("[Foody] 유기농 당당한 여주");
        p39.initStuff(users);
        p39.setPrice(32000);
        p39.setSalePrice(30000);
        p39.calcSaleRate();
        p39.setSaleStatus(true);
        p39.setQuantity(100);
        p39.setCategory(Category.INSTANT);
        p39.setGrade(8);
        productList.add(p39);

        Product p40 = new Product();
        p40.setTitle("[Foody] 유기농 콩 벌조림");
        p40.initStuff(users);
        p40.setPrice(3490);
        p40.setSalePrice(3000);
        p40.calcSaleRate();
        p40.setSaleStatus(true);
        p40.setQuantity(100);
        p40.setCategory(Category.INSTANT);
        p40.setGrade(8);
        productList.add(p40);




        em.persist(users);
        for (Product p : productList) {
            em.persist(p);
        }

        Event event = new Event();
        event.initStuff(users);
        event.initCreateTime();
        event.setImage("1.jpg");
        event.setTitle("푸디푸디");
        event.setDescription("푸디푸디푸디");

        em.persist(event);
    }
}
