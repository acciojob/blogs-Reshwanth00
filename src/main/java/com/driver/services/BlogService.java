package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        return blogRepository1.findAll();
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPubDate(new Date());
        blog.setUser(userRepository1.findById(userId).get());
        blogRepository1.save(blog);
        blog.getUser().getBlogList().add(blog);
        userRepository1.save(blog.getUser());
    }

    public Blog findBlogById(int blogId){
        return blogRepository1.findById(blogId).get();
    }

    public void addImage(Integer blogId, String description, String dimensions){
        Blog blog = blogRepository1.findById(blogId).get();
        Image image = new Image();
        image.setDimensions(dimensions);
        image.setDescription(description);
        blog.getImageList().add(image);
        imageRepository.save(image);
        blogRepository1.save(blog);
    }

    public void deleteBlog(int blogId){
        blogRepository1.deleteById(blogId);
    }
}