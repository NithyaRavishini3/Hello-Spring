package com.rungroop.web.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

//from DTO takes data from frontend and store
@Data
@Builder
public class ClubDto {
    private Long id;
    private String title;
    private String photourl;
    private String cintent;
    private LocalDateTime createdOn;
    private LocalDateTime updateedOn;
}
