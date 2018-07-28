package com.travelsite.traveloffice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

@RequiredArgsConstructor
public abstract class CrudServiceBaseImpl<T> implements CrudService<T,Long> {

    private final JpaRepository<T, Long> repository;


    @Override
    public <S extends T> S add(S entity) {
        return repository.save(entity);
    }

    @Override
    public T findOne(Long primaryKey) {
        return null;
    }

    @Override
    public Iterable<T> findAll() {
        return null;
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void modify(T entity) {

    }

    @Override
    public boolean exists(Long primaryKey) {
        return false;
    }
}
