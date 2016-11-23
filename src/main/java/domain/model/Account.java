package domain.model;

/**
 * Created by Melious on 15.11.2016.
 */
public class Account {

    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private Profile profile;

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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Profile getProfile() {return profile;}

    public void setProfile(Profile profile) {this.profile = profile;}




}
