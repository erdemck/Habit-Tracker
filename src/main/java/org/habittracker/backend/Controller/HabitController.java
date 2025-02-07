package org.habittracker.backend.Controller;

import org.habittracker.backend.Service.HabitService;
import org.habittracker.backend.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {
    HabitService habitService;

    @Autowired
    public HabitController(HabitService HabitService) {
        this.habitService = HabitService;
    }

    @PostMapping
    public Habit addHabit(@RequestBody Habit habit) {
        return habitService.createHabit(habit);
    }

    @GetMapping
    public List<Habit> getAllHabits() {
        return habitService.getAllHabits();
    }

    @GetMapping("/{id}")
    public Habit getHabitById(@PathVariable Long id) {
        return habitService.getHabit(id);
    }

    @PutMapping("/{id}")
    public Habit updateHabit(@RequestBody Habit habit) {
        return habitService.updateHabit(habit);
    }

    @DeleteMapping("/{id}")
    public void deleteHabit(@RequestBody Habit habit) {
        habitService.deleteHabit(habit);
    }

    @PostMapping("/{id}/complete")
    public Habit completeHabit(@PathVariable Long id) {
        return habitService.completeHabit(id);
    }

    @PostMapping("/{id}/reset-streak")
    public void resetStreak(@PathVariable Long id) {
        habitService.resetStreak(id);
    }
}
