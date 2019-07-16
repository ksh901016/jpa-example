package com.corn.cascade.repository;

import com.corn.cascade.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecentPostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByTitleContains(String title, Pageable pageable); // 이름을 분석하여 쿼리를 만들어준다.
}
