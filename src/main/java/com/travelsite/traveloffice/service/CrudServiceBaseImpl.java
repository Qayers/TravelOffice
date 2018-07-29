package com.travelsite.traveloffice.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
        return repository.findById(primaryKey).orElse(null);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }
    @Override
    public void delete(Long id) {
        T t = findOne(id);
        delete(t);
    }


    @Override
    public void modify(T entity) {
        repository.save(entity);
    }

    @Override
    public boolean exists(Long primaryKey) {
        return repository.existsById(primaryKey);
    }
}
