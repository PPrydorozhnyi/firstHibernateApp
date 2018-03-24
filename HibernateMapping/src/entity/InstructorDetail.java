package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by drake on 24/03/18.
 *
 * @author P.Pridorozhny
 */
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GenericGenerator(name = "custom_id", strategy = "generator.CustomIdGenerator")
    @GeneratedValue(generator = "custom_id")
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;
    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail() {

    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
