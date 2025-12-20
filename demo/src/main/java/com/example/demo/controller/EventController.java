package com.example.demo.controller;
import com.example.demo.model.Event;
import com.example.demo.service.EventService;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    public EventController (EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Event> addEvent(
            @PathVariable int id,
            @RequestBody Event event){

        Event existingEvent = eventService.getEventById(id);
        if (existingEvent != null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        event.setId(id);
        Event savedEvent = eventService.addEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);

    }






}
