package com.prjfoody.foody.repository;

import com.prjfoody.foody.domain.Orders;
import com.prjfoody.foody.domain.QOrders;
import com.prjfoody.foody.domain.Users;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Qualifier("OrderRepository")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderRepository implements Repositories<Orders> {

    private final EntityManager em;
    private final JPAQueryFactory q;

    @Override
    public List<Orders> select(Orders orders, Users user) {
        QOrders qOrders = QOrders.orders;

        return q.selectFrom(qOrders)
                .fetch();
    }

    @Override
    public Boolean create(Orders orders, Users user) {
        QOrders qOrders = QOrders.orders;

        try {
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean update(Orders orders, Users user) {
        QOrders qOrders = QOrders.orders;

        try {

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Long id, Users user) {
        QOrders qOrders = QOrders.orders;

        try {
            q.delete(qOrders)
                    .where(qOrders.id.eq(id))
                    .execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
