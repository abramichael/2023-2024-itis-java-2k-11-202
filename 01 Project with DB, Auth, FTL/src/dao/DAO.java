package com.example.votingsystem2.dao;

import java.util.List;

public interface DAO<T> {
    // CRUD
    void create(T u);
    T get(long id);
    void update(T u);
    void delete(long id);
    List<T> getAll();
}
