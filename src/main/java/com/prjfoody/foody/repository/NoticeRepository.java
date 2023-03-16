package com.prjfoody.foody.repository;

import com.prjfoody.foody.domain.Notice;
import com.prjfoody.foody.domain.QNotice;
import com.prjfoody.foody.domain.Users;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Qualifier("NoticeRepository")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class NoticeRepository implements Repositories<Notice> {

    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory q;

    @Override
    public List<Notice> select(Notice notice, Users user) {

        QNotice qNotice = QNotice.notice;
        BooleanBuilder builder = new BooleanBuilder();

        //notice의 id가 있으면 동일한 qnotice 생성
        if (notice.getId() != null)
            builder.and(qNotice.id.eq(notice.getId()));

        return q.selectFrom(qNotice)
                .where(builder)
                .fetch();
    }

    @Override
    public Boolean create(Notice notice, Users user) {

        try {
            if(user.getId()== null)
                em.persist(user);
            em.persist(notice);

            return true;
        } catch (Exception e) {
            log.warn("create notice fail");
            return false;
        }
    }

    @Override
    public Boolean update(Notice notice, Users user) {
        QNotice qNotice = QNotice.notice;

        try{
            q.update(qNotice)
                    .set(qNotice.lastDateTime, notice.getLastDateTime())
                    .set(qNotice.description, notice.getDescription())
                    .set(qNotice.title, notice.getTitle())
                    .where(qNotice.id.eq(notice.getId()))
                    .execute();

            return true;
        } catch(Exception e) {

            return false;
        }
    }

    @Override
    public Boolean delete(Long id, Users user) {
        QNotice qNotice = QNotice.notice;

        try {
            q.delete(qNotice)
                    .where(qNotice.id.eq(id))
                    .execute();

            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
