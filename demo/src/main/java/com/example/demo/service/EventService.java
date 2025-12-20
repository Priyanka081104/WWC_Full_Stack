package com.example.demo.service;
import com.example.demo.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private List<Event> events = new ArrayList<>();

    public List<Event> getAllEvents(){
        return events;
    }
    public Event getEventById(int id){
        return events.stream().filter(e->e.getId() == id).findFirst().orElse(null);
    }
    public Event addEvent(Event event){
        events.add(event);
        return event;
    }

    public boolean deleteEvent(int id){
        return events.removeIf(e->e.getId() == id);
    }


}
