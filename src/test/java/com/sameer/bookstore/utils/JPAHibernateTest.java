package com.sameer.bookstore.utils;

import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

public class JPAHibernateTest {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;

    @BeforeClass
    public static void init()  {
        try
        {
            emf = Persistence.createEntityManagerFactory("BookStoreWebsite");
            em = emf.createEntityManager();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @AfterClass
    public static void tearDown() {
        em.clear();
        em.close();
        emf.close();
    }

    @Before
    public void initializeDatabase() {
        Session session = em.unwrap(Session.class);
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                try {
                    File script = new File(getClass().getResource("/data.sql").getFile());
                    RunScript.execute(connection, new FileReader(script));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("could not initialize with script");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
