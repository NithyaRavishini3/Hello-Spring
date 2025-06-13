package com.rungroop.web.repositary;

import com.rungroop.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface ClubRepositary extends JpaRepository<Club, Long> {
    Optional<Club> findById(Long url);

    //@Query("SELECT c from Club c WHERE c.title LIKE CONCAT('%', :query, '%')");
    //List<Club> searchClubs(String query);

    @Query("SELECT c FROM Club c WHERE c.title LIKE CONCAT('%', :query, '%')")
    List<Club> searchClubs(@Param("query") String query);
}
