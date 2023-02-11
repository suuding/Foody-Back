package com.prjfoody.foody.repository;

import com.prjfoody.foody.domain.Mtm;
import com.prjfoody.foody.domain.QMtm;
import com.prjfoody.foody.domain.QProduct;
import com.prjfoody.foody.domain.Users;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Qualifier("MtmRepository")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MtmRepository implements Repositories<Mtm> {

    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory q;

    @Override
    public List<Mtm> select(Mtm mtm, Users user) {

        QMtm qMtm = QMtm.mtm;
        BooleanBuilder builder = new BooleanBuilder();

        if (mtm.getId() != null)
            builder.and(qMtm.id.eq(mtm.getId()));

        /*
        if (mtm.getOwner() != null)
            builder.and(qMtm.owner.eq(mtm.getOwner()));

        if (mtm.getTitle() != null)
            builder.and(qMtm.title.eq(mtm.getTitle()));
        */

        return q.selectFrom(qMtm)
                .where(builder)
                .fetch();
    }

    @Override
    public Boolean create(Mtm mtm, Users user) {

        try {
            em.persist(user);
            em.persist(mtm);
            return true;
        } catch(Exception e) {
            log.warn("create mtm fail");
            return false;
        }
    }

    @Override
    public Boolean update(Mtm mtm, Users user) {

        QMtm qMtm = QMtm.mtm;

        try {
            q.update(qMtm)
                    .set(qMtm.lastDateTime, mtm.getLastDateTime())
                    .set(qMtm.title, mtm.getTitle())
                    .set(qMtm.content, mtm.getContent())
                    .set(qMtm.status, mtm.getStatus())
                    .where(qMtm.id.eq(mtm.getId()))
                    .execute();

            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(Long id, Users user) {
        QMtm qMtm = QMtm.mtm;

        try {
            q.delete(qMtm)
                    .where(qMtm.id.eq(id))
                    .execute();
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
