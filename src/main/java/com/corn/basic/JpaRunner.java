package com.corn.basic;

import com.corn.basic.repository.AccountRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    AccountRepository repository;

    @Override
    public void run(ApplicationArguments args)  {
        List<Account> accountList = repository.findAll();
        System.out.println(repository.findById(1L));
        System.out.println(accountList);
    }


    public void createAndInert(){
        Account account1 = new Account();
        account1.setName("corn1");
        Account account2 = new Account();
        account2.setName("corn2");

        Hobby soccer = new Hobby();
        soccer.setName("soccer");
        Hobby basketBall = new Hobby();
        basketBall.setName("basketBall");
        Hobby tennis = new Hobby();
        tennis.setName("tennis");
        Hobby golf = new Hobby();
        golf.setName("golf");

        Set<Hobby> account1Hobbies = account1.getHobbies();
        account1Hobbies.add(soccer);
        soccer.setLeader(account1);
        account1Hobbies.add(basketBall);
        basketBall.setLeader(account1);
        account1Hobbies.add(tennis);
        tennis.setLeader(account1);
        account2.getHobbies().add(golf);
        golf.setLeader(account2);

        /* 여기까지가 transient 상태 (JPA가 전혀 모르는 상태)*/

        Session session = entityManager.unwrap(Session.class);
        session.save(account1); /* persistent 상태 (db로 바로 들어가지 않는다.) */
        session.save(account2);
        session.save(soccer);
        session.save(basketBall);
        session.save(tennis);
        session.save(golf);
    }
}
