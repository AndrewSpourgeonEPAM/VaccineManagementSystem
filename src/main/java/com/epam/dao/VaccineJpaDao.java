package com.epam.dao;

import java.util.List;

public interface VaccineJpaDao<T> {
    void update(T t);
    T get(String id);
    List getVaccineData();
    List getLocations();
}
