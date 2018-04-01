package one_to_many.demo;

import one_to_many.entity.Course;
import one_to_many.entity.Instructor;
import one_to_many.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Created by drake on 24/03/18.
 *
 * @author P.Pridorozhny
 */
public class CreateCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        Transaction transaction = null;

        try {

            // start a transaction
            transaction = session.beginTransaction();

            int id = 104;

            Instructor instructor = session.get(Instructor.class, id);

            Course course1 = new Course("Guitar");
            Course course2 = new Course("Piano");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            // commit transaction
            transaction.commit();

            System.out.println("Done!");
        }
        catch (Exception exc) {
            exc.printStackTrace();
            transaction.rollback();
        }
        finally {
            // handle connection leak issue
            session.close();

            factory.close();
        }

    }
}
