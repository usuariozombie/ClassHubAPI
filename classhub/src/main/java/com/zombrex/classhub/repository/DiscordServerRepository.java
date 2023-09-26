package com.zombrex.classhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zombrex.classhub.model.DiscordServer;

/**
 * A repository for managing DiscordServer entities.
 * Extends JpaRepository to provide basic CRUD operations for DiscordServer.
 * 
 * @author usuariozombie
 */
@Repository
public interface DiscordServerRepository extends JpaRepository<DiscordServer, Long> {
    
    /**
     * Find a DiscordServer by its server identifier.
     *
     * @param serverId The server identifier to search for.
     * @return The DiscordServer with the specified server identifier, or null if not found.
     */
    DiscordServer findByServerId(String serverId);
}