package com.driver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String firstName;
    private String password;
    private String lastName;

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public User(){}
    public User(int id,String password,String firstName,String lastName,String username){
        setFirstName(firstName);
        setPassword(password);
        setId(id);
        setLastName(lastName);
        setUsername(username);
    }
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog> blogList;

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}