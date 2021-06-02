package com.sameer.bookstore.utils;


import com.sameer.bookstore.entity.Users;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.RollbackException;
import java.util.List;

import static org.junit.Assert.*;

public class JPAHibernateCRUDTest extends JPAHibernateTest {

    private static Logger logger = LoggerFactory.getLogger(JPAHibernateCRUDTest.class);

    @Test
    public void testGetObjectById_success() {
        logger.info("Testing Get By Id");
        Users users = em.find(Users.class, 1);
        logger.info(users.toString());
        assertNotNull(users);
        assertTrue(users.getUserId()==1);
    }

    @Test
    public void testGetAll_success() {
        logger.info("Testing Get All Users");
        List<Users> users = em.createNamedQuery("Users.getAll", Users.class).getResultList();
        assertTrue(users.size()==1);

    }

    @Test
    public void testPersist_success() {
        logger.info("Testing Persist User");
        em.getTransaction().begin();
        String email="test@test.com";
        String fullName="Test";
        String password="Password";
        Users user=new Users();
        user.setEmail(email);
        user.setPassword(password);
        user.setFullName(fullName);

        em.persist(user);
        em.getTransaction().commit();

        List<Users> users = em.createNamedQuery("Users.getAll", Users.class).getResultList();

        assertNotNull(users);
assertTrue(users.size()==2);
    }

    @Test(expected = RollbackException.class)
    public void testDelete_success(){
        logger.info("Testing Delete User");
        Users users = em.find(Users.class, 1);

        logger.info("User to be deleted is :"+users);
        em.getTransaction().begin();
        em.remove(users);
        em.getTransaction().commit();

        List<Users> books = em.createNamedQuery("Users.getAll", Users.class).getResultList();

        logger.info("Size after deletion: "+books.size());
        assertTrue(books.size()==0);
    }

}

