package com.driver.models;

import javax.persistence.*;

@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String dimensions;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    public Image(){}
    public Image(int id,String description,String dimensions){
        setDescription(description);
        setDimensions(dimensions);
        setId(id);
    }
    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}