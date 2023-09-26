package com.zombrex.classhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a Discord server.
 * 
 * @author usuariozombie
 */
@Entity
public class DiscordServer {
    /**
     * The unique identifier for the Discord server.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The server identifier associated with the Discord server.
     */
    private String serverId;

    /**
     * Default constructor for DiscordServer.
     */
    public DiscordServer() {
    }

    /**
     * Constructor for DiscordServer.
     *
     * @param serverId The server identifier.
     */
    public DiscordServer(String serverId) {
        this.serverId = serverId;
    }

    /**
     * Get the server identifier.
     *
     * @return The server identifier.
     */
    public String getServerId() {
        return serverId;
    }

    /**
     * Set the server identifier.
     *
     * @param serverId The server identifier.
     */
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }
}
