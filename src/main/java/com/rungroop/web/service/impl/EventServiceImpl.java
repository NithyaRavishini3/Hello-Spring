package com.rungroop.web.service.impl;

import com.rungroop.web.dto.EventDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.models.Event;
import com.rungroop.web.repositary.ClubRepositary;
import com.rungroop.web.repositary.EventRepositary;
import com.rungroop.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.rungroop.web.mapper.EventMapper.mapToEvent;
import static com.rungroop.web.mapper.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {

    private EventRepositary eventRepositary;
    private ClubRepositary clubRepositary;

    @Autowired
    public EventServiceImpl(EventRepositary eventRepositary, ClubRepositary clubRepositary){
        this.eventRepositary = eventRepositary;
        this.clubRepositary = clubRepositary;
    }

   @Override
    public void createEvent(Long clubId, EventDto eventDto){
        Club club = clubRepositary.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepositary.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepositary.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

}
