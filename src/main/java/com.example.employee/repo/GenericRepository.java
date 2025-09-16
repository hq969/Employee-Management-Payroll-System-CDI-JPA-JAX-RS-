package com.example.employee.repo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GenericRepository<T> {

    @PersistenceContext(unitName = "employeePU")
    private EntityManager em;

    public T find(Class<T> clazz, Object id) {
        return em.find(clazz, id);
    }

    public List<T> list(Class<T> clazz) {
        return em.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e", clazz).getResultList();
    }

    @Transactional
    public T save(T entity) {
        em.persist(entity);
        return entity;
    }

    @Transactional
    public T update(T entity) {
        return em.merge(entity);
    }

    @Transactional
    public void delete(Class<T> clazz, Object id) {
        T ref = em.find(clazz, id);
        if (ref != null) em.remove(ref);
    }
}

