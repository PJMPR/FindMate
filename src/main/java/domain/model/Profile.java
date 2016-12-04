package domain.model;

import java.util.List;
/**
 * Created by Melious on 15.11.2016.
 */
public class Profile implements IHaveId{

    private int id;
    private int age;
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private List<Like> likes;


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Like> getLikes() {return likes;}

    public void setLikes(List<Like> likes) {this.likes = likes;}





}
