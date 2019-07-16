package com.corn.cascade.repository;

import com.corn.cascade.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PostRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Post add(Post post){
        entityManager.persist(post);
        return post;
    }

    public void delete(Post post){
        entityManager.remove(post);
    }

}
