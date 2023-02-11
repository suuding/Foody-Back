package com.prjfoody.foody.service;

import com.prjfoody.foody.domain.Event;
import com.prjfoody.foody.domain.Mtm;
import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.modules.Validation;
import com.prjfoody.foody.repository.Repositories;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("EventService")
public class EventServices implements Services<Event> {


    private final Repositories<Event> repository;
    private final Validation validation;

    public EventServices(@Qualifier("EventRepository") Repositories<Event> repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public List<Event> select(Event event, Users user) {
        return repository.select(event, user);
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