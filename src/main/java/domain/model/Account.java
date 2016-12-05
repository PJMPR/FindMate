package domain.model;

/**
 * Created by Melious on 15.11.2016.
 */
public class Account implements IHaveId {

    private int id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private Profile profile;
    private int profileId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getProfileId() {return profileId;}

    public void setProfileId(int profileId) {this.profileId = profileId;}
}
