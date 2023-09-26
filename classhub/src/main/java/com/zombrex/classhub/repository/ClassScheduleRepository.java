package com.zombrex.classhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zombrex.classhub.model.ClassSchedule;

import java.util.List;

/**
 * Repository interface for managing ClassSchedule entities.
 * 
 * @author usuariozombie
 */
@Repository
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Long> {

    /**
     * Find a list of ClassSchedule entities by their associated server identifier.
     *
     * @param serverId The server identifier to search for.
     * @return A list of ClassSchedule entities matching the given server identifier.
     */
    List<ClassSchedule> findByServerId(String serverId);
}
