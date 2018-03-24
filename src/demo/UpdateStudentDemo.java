package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by drake on 14/02/18.
 *
 * @author P.Pridorozhny
 */
public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        int studentId = 1;

        try {

            session.beginTransaction();

            Student student = session.get(Student.class, studentId);

            student.setEmail("something");

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
