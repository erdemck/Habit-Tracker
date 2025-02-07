package org.habittracker.backend.Service;

import org.habittracker.backend.Repo.HabitRepository;
import org.habittracker.backend.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public Habit createHabit(Habit habit) {
        return habitRepository.create(habit);
    }

    public Habit getHabit(Long id) { return habitRepository.findById(id); }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Habit updateHabit(Habit habit) {
        return habitRepository.update(habit);
    }

    public void deleteHabit(Habit habit) {
        habitRepository.delete(habit);
    }

    public Habit completeHabit(Long id) {
        Habit habit = habitRepository.findById(id);
        if (habit == null) {
            throw new IllegalArgumentException("Habit not found with id: " + id);
        }

        LocalDate today = LocalDate.now();
        LocalDate lastCompleted = habit.getLastCompletedDate();

        if (lastCompleted == null) {
            // First Streak Started
            habit.setCurrentStreak(1);
            habit.setBestStreak(1);
        } else {
            //Get the number of days between last completed date and today
            long daysBetween = ChronoUnit.DAYS.between(lastCompleted, today);
            
            if (daysBetween == 1) {
                // If it is consecutive day, increase the streak
                int newStreak = habit.getCurrentStreak() + 1;
                habit.setCurrentStreak(newStreak);
                
                if (newStreak > habit.getBestStreak()) {
                    habit.setBestStreak(newStreak);
                }
            } else if (daysBetween == 0) {
                // If it is the same day, do not change the streak
                return habit;
            } else {
                // Streak is broken, begin a new streak
                habit.setCurrentStreak(1);
            }
        }

        habit.setLastCompletedDate(today);
        return habitRepository.update(habit);
    }

    public void resetStreak(Long id) {
        Habit habit = habitRepository.findById(id);
        if (habit == null) {
            throw new IllegalArgumentException("Habit not found with id: " + id);
        }
        
        habit.setCurrentStreak(0);
        habit.setLastCompletedDate(null);
        habitRepository.update(habit);
    }
}
