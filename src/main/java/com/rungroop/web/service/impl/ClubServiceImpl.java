package com.rungroop.web.service.impl;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.repositary.ClubRepositary;
import com.rungroop.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ClubServiceImpl implements ClubService {

    private ClubRepositary clubRepositary;

    @Autowired
    public ClubServiceImpl(ClubRepositary clubRepositary) {
        this.clubRepositary = clubRepositary;
    }

    @Override
    public List<ClubDto> findAllClubs() {
       List<Club> clubs = clubRepositary.findAll();
       return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    private ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photourl(club.getPhotourl())
                .cintent(club.getCintent())
                .createdOn(club.getCreatedOn())
                .updateedOn(club.getUpdateedOn())
                .build();
        return clubDto;
    }
}
