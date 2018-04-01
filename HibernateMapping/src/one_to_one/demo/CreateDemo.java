package one_to_one.demo;

import one_to_one.entity.Instructor;
import one_to_one.entity.InstructorDetail;
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

//        Instructor instructor = new Instructor("Matt", "Jones", "mj@gmao;.com");
//
//        InstructorDetail instructorDetail = new InstructorDetail("yout", "football");
//
//        instructor.setInstructorDetail(instructorDetail);

        int instructorDetailId = 105;

        try {
            session.beginTransaction();

            // save all because of cascade
//            session.save(instructor);

            InstructorDetail instructorDetail =
                    session.get(InstructorDetail.class, instructorDetailId);

            System.out.println(instructorDetail);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }

    }
}
