package com.portfolio.tellmewhenapp.service;

import java.util.List;

public interface IProductService<T> {

    void add(T entity);

    void update(T entity);

    void delete(Integer id);

    T findOne(Integer id);

    List<T> getAll();
}
