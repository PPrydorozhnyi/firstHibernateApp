package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by drake on 13/02/18.
 *
 * @author P.Pridorozhny
 */
public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> students = (List<Student>) session.createQuery("from Student").getResultList();

            displayStudents(students);

//            students = session.createQuery("from Student s where s.lastName = 'Smith'").getResultList();
//
//            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName = 'Donalds'" +
                    "or s.firstName = 'John'").getResultList();

            session.getTransaction().commit();


        } finally {
            factory.close();
        }


    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students)
            System.out.println(student);
    }
}
