package com.hbn1.app;

import com.hbn1.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchApp2 {
    public static void main(String[] args) {
        Configuration cfg = null;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        boolean flag = false;

        cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
        session = sf.openSession();

        Student stu = new Student();
        stu.setId(5);
        stu.setName("venkat");
        stu.setAge(22);
        stu.setCity("palakol");

        try {
            tx = session.beginTransaction();
            session.persist(stu);
            flag = true;
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (flag) {
                tx.commit();
            }
            else {
                tx.rollback();
            }
            session.close();
            sf.close();
        }
    }
}
