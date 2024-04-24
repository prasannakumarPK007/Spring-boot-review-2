package com.eventmanagement.login.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.eventmanagement.login.model.Event;
import com.eventmanagement.login.repository.EventRepository;

@Service
public class EventService {
    public EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event postEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEvent(int id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<Event> gEventAll(int no, int si, String field) {
        return eventRepository.findAll(PageRequest.of(no, si, Sort.by(Direction.DESC, field))).getContent();
    }

    public void deleteeEvent(int id) {
        eventRepository.deleteById(id);
    }

    public List<Event> yyEvents(int a) {
        return eventRepository.findByMembersGreaterThan(a);
    }
}
