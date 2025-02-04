package org.habittracker.backend.Repo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.habittracker.backend.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class HabitRepository  implements IRepository<Habit> {
    EntityManager em;

    @Autowired
    public HabitRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Habit findById(Long id) {
        return em.find(Habit.class, id);
    }

    @Override
    @Transactional
    public Habit create(Habit habit) {
        return em.merge(habit);
    }

    @Override
    @Transactional
    public Habit update(Habit habit) {
        return em.merge(habit);
    }

    @Override
    @Transactional
    public void delete(Habit habit) {
        em.remove(habit);
    }

    @Override
    public List<Habit> findAll() {
        return em.createQuery("SELECT h FROM Habit h").getResultList();
    }
}
