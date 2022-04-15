package com.epam.dao;

public interface JpaDao<T> {

    void create(T t);
    void update(T t);
    T get(String id);
    void delete(String id);

}
