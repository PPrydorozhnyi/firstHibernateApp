package one_to_many.entity;

import one_to_many.entity.Instructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by drake on 01/04/18.
 *
 * @author P.Pridorozhny
 */
@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "course_id")
    @GenericGenerator(name = "custom_id", strategy = "generator.CustomIdGenerator")
    @GeneratedValue(generator = "custom_id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST,
    CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Course() {}

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
