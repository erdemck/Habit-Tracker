package org.habittracker.backend.Repo;

import java.util.List;

public interface  IRepository<T> {
    public T findById(Long id);
    public T create(T t);
    public T update(T t);
    public void delete(T t);
    public List<T> findAll();
}
