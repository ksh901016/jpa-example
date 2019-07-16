package com.corn.cascade.repository;

import com.corn.cascade.Post;

import java.util.List;

public interface PostCustomRepository<T> {
    List<Post> findMyPost();
    void delete(T entity);
}
