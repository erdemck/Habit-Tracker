package org.habittracker.backend.Repo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.habittracker.backend.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppUserRepository implements IRepository<AppUser> {
    EntityManager em;

    @Autowired
    public AppUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public AppUser findById(Long id) {
        return em.find(AppUser.class, id);
    }

    @Override
    @Transactional
    public AppUser create(AppUser AppUser) {
        return em.merge(AppUser);
    }

    @Override
    @Transactional
    public AppUser update(AppUser AppUser) {
        return em.merge(AppUser);
    }

    @Override
    @Transactional
    public void delete(AppUser AppUser) {
        em.remove(AppUser);
    }

    @Override
    public List<AppUser> findAll() {
        return em.createQuery("select u from AppUser u", AppUser.class).getResultList();
    }
}
