package com.prjfoody.foody.repository;

import com.prjfoody.foody.domain.QProduct;
import com.prjfoody.foody.domain.QUsers;
import com.prjfoody.foody.domain.Users;
import com.querydsl.core.BooleanBuilder;
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
@Qualifier("UserRepository")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserRepository implements Repositories<Users> {

    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory q;

    @Override
    public List<Users> select(Users users, Users user) {
        QUsers qUsers = QUsers.users;
        BooleanBuilder builder = new BooleanBuilder();

        if(users == null)
            return null;

        if(users.getId()!= null)
            builder.and(qUsers.id.eq(users.getId()));

        System.out.println("users.getId() = " + users.getId());
        System.out.println(" = " + users.getName());
        System.out.println(" = " + users.getPasswd());

        if (users.getName() != null && users.getPasswd() != null) {
            builder.and(qUsers.name.eq(users.getName()));
            builder.and(qUsers.passwd.eq(user.getPasswd()));
        }

        return q.selectFrom(qUsers)
                .where(builder)
                .fetch();
    }

    @Override
    public Boolean create(Users users, Users user) {
        try {
            em.persist(users);

            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Boolean update(Users users, Users user) {
        QUsers qUsers = QUsers.users;

        if(users == null)
            return null;

        try {
            JPAUpdateClause update = q.update(qUsers);

            if (users.getName() != null)
                update.set(qUsers.name, users.getName());

            if (users.getPasswd() != null)
                update.set(qUsers.passwd, users.getPasswd());

            if (users.getTel() != null)
                update.set(qUsers.tel, users.getTel());

            if (users.getEmail() != null)
                update.set(qUsers.email, users.getEmail());

            if (users.getAddress() != null)
                update.set(qUsers.address, users.getAddress());

            if (users.getBirth() != null)
                update.set(qUsers.birth, users.getBirth());

            update.where(qUsers.id.eq(user.getId()))
                        .execute();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Long id, Users user) {
        QUsers qUsers = QUsers.users;

        try {

            q.delete(qUsers)
                    .where(qUsers.id.eq(id)).execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
