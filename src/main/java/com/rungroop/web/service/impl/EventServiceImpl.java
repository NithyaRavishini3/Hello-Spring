package com.rungroop.web.service.impl;

import com.rungroop.web.dto.EventDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.models.Event;
import com.rungroop.web.repositary.ClubRepositary;
import com.rungroop.web.repositary.EventRepositary;
import com.rungroop.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private Event mapToEvent(EventDto eventDto){
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .photourl(eventDto.getPhotourl())
               // .createdOn(eventDto.getCreatedOn())
               // .updatedOn(eventDto.getUpdatedOn())
                .build();
    }



}
