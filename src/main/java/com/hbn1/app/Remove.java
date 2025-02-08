package com.hbn1.app;

import com.hbn1.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Remove {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = null;
        Transaction tx = null;
        boolean flag = false;
        try{
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Student s = new Student();
            s.setId(2);
            s.setName("Sri");
            s.setAge(22);
            s.setCity("bhimavaram");
            session.remove(s);
            flag = true;

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
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
            sessionFactory.close();
        }
    }
}
