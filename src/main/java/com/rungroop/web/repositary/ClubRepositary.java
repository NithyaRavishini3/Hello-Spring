package com.rungroop.web.repositary;

import com.rungroop.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepositary extends JpaRepository<Club, Long> {
    Optional<Club> findById(Long url);
}
