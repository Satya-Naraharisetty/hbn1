package com.hbn1.app;

import com.hbn1.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchApp1 {
    public static void main(String[] args) {
        //step 1: create config object
        Configuration cfg = new Configuration();

        //step 2: configure hibernate.cfg.xml file to cfg object
        cfg.configure("hibernate.cfg.xml");

        //step 3: create sessionFactory object
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        //step 4: get session object from sessionFactory
        Session session = sessionFactory.openSession();

        //step 5: begin the transaction from session object
        Transaction tx = session.beginTransaction();

        Student stu = new Student();
        stu.setId(2);
        stu.setName("satya");
        stu.setAge(22);
        stu.setCity("palakol");

        //step 6: perform operation
        session.save(stu);

        //step 7: perform transaction operation
        tx.commit();

        //step 8: close session
        session.close();

    }
}
