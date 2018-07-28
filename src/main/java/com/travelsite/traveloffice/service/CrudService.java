package com.travelsite.traveloffice.service;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

public interface CrudService<T, ID extends Serializable> extends Repository<T, ID> {

    <S extends T> S add(S entity);

    T findOne(ID primaryKey);

    Iterable<T> findAll();

    Long count();

    void delete(T entity);

    void modify(T entity);

    boolean exists(ID primaryKey);
}

