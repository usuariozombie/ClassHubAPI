package com.zombrex.classhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class to represent an class schedule entity.
 * 
 * @author usuariozombie
 */
@Entity
public class ClassSchedule {
    /**
     * The unique identifier for the class schedule.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The server identifier associated with the class schedule.
     */
    private String serverId;

    /**
     * The day of the week for the class.
     */
    private String classDay;

    /**
     * The hour of the class.
     */
    private String classHour;

    /**
     * The subject of the class.
     */
    private String subject;

    /**
     * Default constructor for ClassSchedule.
     */
    public ClassSchedule() {
    }

    /**
     * Constructor for ClassSchedule.
     *
     * @param serverId  The server identifier.
     * @param classDay  The day of the class.
     * @param classHour The hour of the class.
     * @param subject   The subject of the class.
     */
    public ClassSchedule(String serverId, String classDay, String classHour, String subject) {
        this.serverId = serverId;
        this.classDay = classDay;
        this.classHour = classHour;
        this.subject = subject;
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

    /**
     * Get the day of the class.
     *
     * @return The day of the class.
     */
    public String getClassDay() {
        return classDay;
    }

    /**
     * Set the day of the class.
     *
     * @param classDay The day of the class.
     */
    public void setClassDay(String classDay) {
        this.classDay = classDay;
    }

    /**
     * Get the hour of the class.
     *
     * @return The hour of the class.
     */
    public String getClassHour() {
        return classHour;
    }

    /**
     * Set the hour of the class.
     *
     * @param classHour The hour of the class.
     */
    public void setClassHour(String classHour) {
        this.classHour = classHour;
    }

    /**
     * Get the subject of the class.
     *
     * @return The subject of the class.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Set the subject of the class.
     *
     * @param subject The subject of the class.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
