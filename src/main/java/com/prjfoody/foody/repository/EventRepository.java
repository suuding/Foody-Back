package com.prjfoody.foody.repository;

import com.prjfoody.foody.domain.Event;
import com.prjfoody.foody.domain.QEvent;
import com.prjfoody.foody.domain.Users;
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
@Qualifier("EventRepository")
@Slf4j
@RequiredArgsConstructor
@Transactional
public class EventRepository implements Repositories<Event> {

    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory q;

    @Override
    public List<Event> select(Event event, Users user) {
        QEvent qEvent = QEvent.event;
        return q.selectFrom(qEvent).fetch();
    }

    @Override
    public Boolean create(Event event, Users user) {
        return null;
    }

    @Override
    public Boolean update(Event event, Users user) {
        return null;
    }

    @Override
    public Boolean delete(Long id, Users user) {
        return null;
    }
}