package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by drake on 13/02/18.
 *
 * @author P.Pridorozhny
 */
public class GetStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

//            Student student = new Student("Daffy", "Donalds", "empty");
//
//            session.beginTransaction();
//
//            session.save(student);
//
//            session.getTransaction().commit();

            session = factory.getCurrentSession();

            session.beginTransaction();

            Student student1 = session.get(Student.class, 5);

            System.out.println(student1);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
