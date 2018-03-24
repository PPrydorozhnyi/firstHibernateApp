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
public class CreateStudentDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            Student student = new Student("Johntt", "Smith", "something@gmail.com");

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();


        } finally {
            factory.close();
        }
    }
}
