package com.driver.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table

public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private Date pubDate;
    public Blog(){}

    public int getId() {
        return id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public String getContent() {
        return content;
    }
    public String getTitle() {
        return title;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
    public Blog(int id, String content,String title, Date pubDate){
        setId(id);
        setContent(content);
        setTitle(title);
        setPubDate(pubDate);
    }
    @ManyToOne
    @JoinColumn
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> imageList;

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}