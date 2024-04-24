package com.eventmanagement.login.controller;

import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.login.model.Event;
import com.eventmanagement.login.service.EventService;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/event")
public class EventController {
    public EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/post")
    public Event postMethodName(@RequestBody Event event) {
        return eventService.postEvent(event);
    }

    @GetMapping("/get/pno/siz/field")
    public List<Event> getMethodName(@PathVariable("pno") int pa, @PathVariable("siz") int siz,
            @PathVariable("field") String field) {
        return eventService.gEventAll(pa, siz, field);
    }

    @GetMapping("/get/{id}")
    public Event getMethodName(@PathVariable("id") int id, @RequestBody Event event) {
        return eventService.getEvent(id);
    }

    @PutMapping("/path/{id}")
    public String putMethodName(@PathVariable int id, @RequestBody Event event) {
        Event event2 = eventService.getEvent(id);
        if (event2 != null) {
            event2.setFoods(event.getFoods());
            event2.setDesserts(event.getDesserts());
            event2.setMembers(event.getMembers());
            event2.setPackageprice(event.getPackageprice());
            eventService.postEvent(event2);
        } else {
            return "inavalid id";
        }
        return "updated sucessfully";
    }

    @DeleteMapping("/del/{id}")
    public String deleteString(@PathVariable("id") int id) {
        Event event = eventService.getEvent(id);
        if (event != null) {
            eventService.deleteeEvent(id);
        } else {
            return "invalid id";
        }
        return "deleted sucessfully";

    }

    @GetMapping("/gets/{pac}")
    public List<Event> gEvents(@PathVariable("pac") int pac) {
        return eventService.yyEvents(pac);
    }

}
