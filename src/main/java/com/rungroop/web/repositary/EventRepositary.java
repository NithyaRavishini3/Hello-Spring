package com.rungroop.web.repositary;

import com.rungroop.web.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public class EventRepositary extends JpaRepository<Event, Long> {
}
