package com.portfolio.TellMeWhenApp.Service;

import java.util.List;

public interface GenericProductService<T> {

    void save(T entity);

    void update(T entity);

    void delete(Integer id);

    T findOne(Integer id);

    List<T> getAll();
}
