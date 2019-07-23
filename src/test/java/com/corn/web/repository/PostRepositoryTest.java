package com.corn.web.repository;

import com.corn.web.post.Post;
import com.corn.web.post.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void save(){
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post); // insert (persist)
        // 객체가 영속화되어있음
        assertThat(entityManager.contains(post)).isTrue();
        assertThat(entityManager.contains(savedPost)).isTrue();
        assertThat(savedPost == post);

        post = new Post();
        post.setId(1l);
        post.setTitle("hibernate");
        postRepository.save(post); // update (upate)

        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

    private Post savePost(){
        Post post = new Post();
        post.setTitle("jpa");
        return postRepository.save(post); // insert (persist)
    }

    @Test
    public void findByTitle(){
        savePost();
        List<Post> all = postRepository.findByTitle("jpa");
        assertThat(all.size()).isEqualTo(1);
    }


}
