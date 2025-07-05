package com.rungroop.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "YYYY-MM-dd 'T'HH:mm")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "YYYY-MM-dd 'T'HH:mm")
    private LocalDateTime endTime;
    private String type;
    private String photourl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<EventDto> events;
}
