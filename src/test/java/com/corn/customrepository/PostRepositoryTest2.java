package com.corn.customrepository;

import com.corn.cascade.Post;
import com.corn.cascade.repository.RecentPostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest2 {

    @Autowired
    RecentPostRepository postRepository;

    @Test
    public void crud(){
        postRepository.findMyPost();

        Post post = new Post();
        post.setTitle("hibernate");
        postRepository.save(post);
        postRepository.findMyPost();
        postRepository.delete(post);
        postRepository.flush();
        // flush를 호출하면, db와 sync를 맞춘다. (delete쿼리를 날린다.)
        // save , delete하면 db에 sync를 맞출필요가 없다고 생각하여 JPA는 query를 날리지 않는다.
    }
}
