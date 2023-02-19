package com.sgc.repository;

import com.sgc.model.Competency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetencyRepository extends JpaRepository<Competency, Long> {

    @Modifying
    @Query("UPDATE Competency c SET c.status = com.sgc.model.enums.Status.INACTIVE WHERE c.id = :idCompetency")
    void updateStatus(@Param("idCompetency") Long idCompetency);
}
