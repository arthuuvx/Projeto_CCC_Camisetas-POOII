package br.com_ifg.dao;

import java.util.List;

public interface DAO<T, ID> {
    void save(T entity);
    T findByID(ID id);
    List<T> findAll();
    void update(T entity);
    void delete(ID id);
}
