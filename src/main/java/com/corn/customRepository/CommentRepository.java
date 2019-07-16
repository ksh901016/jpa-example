package com.corn.customRepository;

import com.corn.cascade.Comment;

import java.util.List;

public interface CommentRepository extends MyRepository<Comment, Long> {
    List<Comment> findByTitleContains(String keyword);
}
