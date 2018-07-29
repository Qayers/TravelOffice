package com.travelsite.traveloffice.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;


public interface CrudService<T, ID extends Serializable>  {


    <S extends T> S add(S entity);

    T findOne(ID primaryKey);

    Iterable<T> findAll();

    Long count();

    void delete(T entity);
    void delete(ID id);

    void modify(T entity);

    boolean exists(ID primaryKey);
}

