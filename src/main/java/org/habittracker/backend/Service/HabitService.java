package org.habittracker.backend.Service;

import org.habittracker.backend.Repo.HabitRepository;
import org.habittracker.backend.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public Habit createHabit(Habit habit) {
        return habitRepository.create(habit);
    }

    public Habit getHabit(Long id) {
        return habitRepository.findById(id);
    }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }
}
