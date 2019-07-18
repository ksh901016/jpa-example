package com.corn.customRepository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BasicCustomizingRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BasicCustomizingRepository<T, ID> {

    private EntityManager entityManager;

    public BasicCustomizingRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }
}
