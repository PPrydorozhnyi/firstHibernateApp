package demo;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by drake on 24/03/18.
 *
 * @author P.Pridorozhny
 */
public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        Instructor instructor = new Instructor("Matt", "Jones", "mj@gmao;.com");

        InstructorDetail instructorDetail = new InstructorDetail("yout", "football");

        instructor.setInstructorDetail(instructorDetail);

        try {
            session.beginTransaction();

            // save all because of cascade
            session.save(instructor);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
