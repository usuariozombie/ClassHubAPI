package com.zombrex.classhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zombrex.classhub.model.ClassSchedule;
import com.zombrex.classhub.repository.ClassScheduleRepository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Service class for managing class schedules.
 */
@Service
public class ClassScheduleService {

	/**
	 * The ClassScheduleRepository responsible for data access and persistence of class schedules.
	 */
    private final ClassScheduleRepository scheduleRepository;

    /**
     * Constructor for ClassScheduleService.
     *
     * @param scheduleRepository The repository for managing class schedules.
     */
    @Autowired
    public ClassScheduleService(ClassScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    /**
     * Add a new class schedule.
     *
     * @param serverId The server identifier.
     * @param day      The day of the class.
     * @param hour     The hour of the class.
     * @param subject  The subject of the class.
     * @return True if the schedule was added successfully, false if it already exists.
     */
    public boolean addSchedule(String serverId, String day, String hour, String subject) {
        // Check if a record with the same day and hour already exists in the database
        List<ClassSchedule> existingSchedules = scheduleRepository.findByServerId(serverId);
        for (ClassSchedule schedule : existingSchedules) {
            if (schedule.getClassDay().equals(day) && schedule.getClassHour().equals(hour)) {
                return false; // The record already exists, cannot add
            }
        }

        // Create and save the new record
        ClassSchedule newSchedule = new ClassSchedule(serverId, day, hour, subject);
        scheduleRepository.save(newSchedule);
        return true;
    }

    /**
     * Get a formatted class schedule for a server.
     *
     * @param serverId The server identifier.
     * @return A formatted class schedule.
     */
    public String getFormattedSchedule(String serverId) {
        // Get all schedule records for the server
        List<ClassSchedule> schedules = scheduleRepository.findByServerId(serverId);

        // Create a map to group subjects by day of the week and hour
        Map<String, Map<String, StringBuilder>> scheduleByDayAndHour = new TreeMap<>();

        // Iterate over subjects and group them by day and hour
        for (ClassSchedule schedule : schedules) {
            String classDay = schedule.getClassDay();
            String classHour = schedule.getClassHour();
            StringBuilder daySchedule = scheduleByDayAndHour
                    .computeIfAbsent(classDay, k -> new TreeMap<>())
                    .computeIfAbsent(classHour, k -> new StringBuilder());

            daySchedule.append(schedule.getSubject()).append(" | ");
        }

        // Build the response with line breaks between days and hours in the desired order
        StringBuilder scheduleBuilder = new StringBuilder();
        for (String day : scheduleByDayAndHour.keySet()) {
            StringBuilder daySchedule = new StringBuilder();
            for (String hour : scheduleByDayAndHour.get(day).keySet()) {
                StringBuilder hourSchedule = scheduleByDayAndHour.get(day).get(hour);
                if (hourSchedule.length() > 0) {
                    daySchedule.append(hour).append(" - ").append(hourSchedule);
                }
            }
            if (daySchedule.length() > 0) {
                scheduleBuilder.append(day).append(": ").append(daySchedule).append("\n");
            }
        }

        return scheduleBuilder.toString();
    }

    /**
     * Edit an existing class schedule.
     *
     * @param serverId The server identifier.
     * @param day      The day of the class.
     * @param hour     The hour of the class.
     * @param subject  The new subject for the class.
     * @return True if the schedule was edited successfully, false if not found.
     */
    public boolean editSchedule(String serverId, String day, String hour, String subject) {
        // Get the schedule record to edit from the database
        List<ClassSchedule> schedules = scheduleRepository.findByServerId(serverId);
        for (ClassSchedule schedule : schedules) {
            if (schedule.getClassDay().equals(day) && schedule.getClassHour().equals(hour)) {
                schedule.setSubject(subject);
                scheduleRepository.save(schedule);
                return true; // The record has been edited
            }
        }
        return false; // No record found to edit
    }

    /**
     * Delete an existing class schedule.
     *
     * @param serverId The server identifier.
     * @param day      The day of the class.
     * @param hour     The hour of the class.
     * @return True if the schedule was deleted successfully, false if not found.
     */
    public boolean deleteSchedule(String serverId, String day, String hour) {
        // Get all schedule records for the server
        List<ClassSchedule> schedules = scheduleRepository.findByServerId(serverId);

        for (ClassSchedule schedule : schedules) {
            if (schedule.getClassDay().equals(day) && schedule.getClassHour().equals(hour)) {
                scheduleRepository.delete(schedule);
                return true; // The record has been deleted
            }
        }
        return false; // No record found to delete
    }
}
