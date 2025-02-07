package org.habittracker.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

enum RepeatCycle{
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday
}

@Entity
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ElementCollection(targetClass = RepeatCycle.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "repeat_cycle_table", joinColumns = @JoinColumn(name = "your_entity_id"))
    @Column(name = "repeat_cycle")
    private Set<RepeatCycle> repeatCycle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("habits")
    private AppUser user;

    @Column(name = "current_streak")
    private int currentStreak = 0;

    @Column(name = "best_streak")
    private int bestStreak = 0;

    @Column(name = "last_completed_date")
    private LocalDate lastCompletedDate;

    public Habit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Habit() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<RepeatCycle> getRepeatCycle() {
        return repeatCycle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public void setRepeatCycle(Set<RepeatCycle> repeatCycle) {
        this.repeatCycle = repeatCycle;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public int getBestStreak() {
        return bestStreak;
    }

    public void setBestStreak(int bestStreak) {
        this.bestStreak = bestStreak;
    }

    public LocalDate getLastCompletedDate() {
        return lastCompletedDate;
    }

    public void setLastCompletedDate(LocalDate lastCompletedDate) {
        this.lastCompletedDate = lastCompletedDate;
    }
}

