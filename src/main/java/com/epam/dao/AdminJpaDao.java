package com.epam.dao;

public interface AdminJpaDao<T> {
    T get(String id);
}
