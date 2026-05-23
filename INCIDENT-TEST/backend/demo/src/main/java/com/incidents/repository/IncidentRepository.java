package com.incidents.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incidents.entity.Incident;

@Repository
public interface IncidentRepository
        extends JpaRepository<Incident, Long> {

    // =========================
    // FILTER BY SEVERITY
    // =========================

    Page<Incident> findBySeverity(

            String severity,

            Pageable pageable
    );

    // =========================
    // FILTER BY STATUS
    // =========================

    Page<Incident> findByStatus(

            String status,

            Pageable pageable
    );

    // =========================
    // SEARCH TITLE
    // =========================

    Page<Incident> findByTitleContainingIgnoreCase(

            String title,

            Pageable pageable
    );
}