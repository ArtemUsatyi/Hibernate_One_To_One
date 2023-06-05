package ru.springCrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.springCrud.model.Director;
import ru.springCrud.model.School;

public class ApplicationHibernateOneToOne {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Director director = session.get(Director.class, 1);
            School school = director.getSchool();
            System.out.println("Получение название школы через Директора в переменную school -" + school.getName());
            System.out.println("Получение название школы напрямую через директора -" + director.getSchool().getName());
            System.out.println("Имя директора - " + director.getName());

//            Director director1 = new Director("Петрович", 50);
//            School school1 = new School("Вторая школа",director1);
//            director1.setSchool(school1);
//            session.save(director1);
//            session.save(school1);
//
//            System.out.println(director1.getSchool().getName());
//            System.out.println(school1.getDirector().getName());


//            Director director1 = session.get(Director.class, 6);
//            School school1 = session.get(School.class, 4);
//            school1.setDirector(director1);
//            director1.setSchool(school1);
//            System.out.println(director1.getSchool().getName());


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
