package dto;


import javax.persistence.Entity;

/**
 * Created by drake on 12/02/18.
 *
 * @author P.Pridorozhny
 */

@Entity
public class UserDetails {

    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
