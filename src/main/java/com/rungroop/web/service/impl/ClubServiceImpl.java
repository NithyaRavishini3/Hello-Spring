package com.rungroop.web.service.impl;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.repositary.ClubRepositary;
import com.rungroop.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.rungroop.web.mapper.ClubMapper.mapToClub;
import static com.rungroop.web.mapper.ClubMapper.mapToClubDto;

@Service
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

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        return clubRepositary.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepositary.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepositary.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepositary.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query){
        List<Club> clubs = clubRepositary.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

}
