package com.prjfoody.foody.repository;

import com.prjfoody.foody.domain.Basket;
import com.prjfoody.foody.domain.QBasket;
import com.prjfoody.foody.domain.QUsers;
import com.prjfoody.foody.domain.Users;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Qualifier("BasketRepository")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BasketRepository implements Repositories<Basket> {
    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory q;

    // user 정보가 들어오면 user의 id를 가지고 조회하는 기능만 제공함
    @Override
    public List<Basket> select(Basket basket, Users user) {
        QBasket qBasket = QBasket.basket;
        if (user == null || user.getId() == null)
            return null;

        return q.selectFrom(qBasket)
                .where(qBasket.user.id.eq(user.getId()))
                .fetch();
    }

    @Override
    public Boolean create(Basket basket, Users user) {
        try {
            em.persist(basket);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean update(Basket basket, Users user) {
        QBasket qBasket = QBasket.basket;

        if(user == null)
            return null;

        try {
            JPAUpdateClause update = q.update(qBasket);

            if (basket.getQuantity() != null)
                update.set(qBasket.quantity, basket.getQuantity());

            update.where(qBasket.id.eq(basket.getId()))
                    .execute();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Long id, Users user) {
        QBasket qBasket = QBasket.basket;

        if(user == null)
            return null;

        try {
            q.delete(qBasket)
                    .where(qBasket.id.eq(id))
                    .execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
