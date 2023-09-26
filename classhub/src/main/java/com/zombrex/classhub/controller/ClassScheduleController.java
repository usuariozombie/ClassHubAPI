package com.zombrex.classhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zombrex.classhub.service.ClassScheduleService;

/**
 * Controller class for managing class schedules via REST API.
 * 
 * @author usuariozombie
 */
@RestController
@RequestMapping("/api")
public class ClassScheduleController {

	/**
	 * The ClassScheduleService responsible for managing class schedules.
	 */
    private final ClassScheduleService scheduleService;

    /**
     * Constructor for ClassScheduleController.
     *
     * @param scheduleService The ClassScheduleService used for managing class schedules.
     */
    @Autowired
    public ClassScheduleController(ClassScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    /**
     * Endpoint for adding a class schedule.
     *
     * @param serverId The server identifier.
     * @param day      The day of the class.
     * @param hour     The hour of the class.
     * @param subject  The subject of the class.
     * @return A ResponseEntity with a success message if added successfully, or an error message if not.
     */
    @PostMapping("/add")
    public ResponseEntity<String> addSchedule(
            @RequestParam String serverId,
            @RequestParam String day,
            @RequestParam String hour,
            @RequestParam String subject) {

        boolean added = scheduleService.addSchedule(serverId, day, hour, subject);

        if (added) {
            return ResponseEntity.ok("You have registered the subject successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("The registry is already taken, please change it with /edit!");
        }
    }

    /**
     * Endpoint for retrieving a formatted class schedule.
     *
     * @param serverId The server identifier.
     * @return A ResponseEntity containing the formatted class schedule, or an error message if not found.
     */
    @GetMapping("/schedule")
    public ResponseEntity<String> getSchedule(@RequestParam String serverId) {
        String schedule = scheduleService.getFormattedSchedule(serverId);
        return ResponseEntity.ok(schedule);
    }

    /**
     * Endpoint for editing a class schedule.
     *
     * @param serverId The server identifier.
     * @param day      The day of the class.
     * @param hour     The hour of the class.
     * @param subject  The subject of the class.
     * @return A ResponseEntity with a success message if edited successfully, or an error message if not found.
     */
    @PutMapping("/edit")
    public ResponseEntity<String> editSchedule(
            @RequestParam String serverId,
            @RequestParam String day,
            @RequestParam String hour,
            @RequestParam String subject) {

        boolean edited = scheduleService.editSchedule(serverId, day, hour, subject);

        if (edited) {
            return ResponseEntity.ok("The registration has been edited!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No registry was found to edit.");
        }
    }

    /**
     * Endpoint for deleting a class schedule.
     *
     * @param serverId The server identifier.
     * @param day      The day of the class.
     * @param hour     The hour of the class.
     * @return A ResponseEntity with a success message if deleted successfully, or an error message if not found.
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSchedule(
            @RequestParam String serverId,
            @RequestParam String day,
            @RequestParam String hour) {

        boolean deleted = scheduleService.deleteSchedule(serverId, day, hour);

        if (deleted) {
            return ResponseEntity.ok("The registry has been deleted!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No registry was found to delete");
        }
    }
}
