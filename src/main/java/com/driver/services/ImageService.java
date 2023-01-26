package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    BlogRepository blogRepository;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        Image image=new Image();
        image.setDimensions(dimensions);
        image.setDescription(description);
        image.setBlog(blog);
        List<Image> res=blog.getImageList();
        if(res==null){
            res=new ArrayList<>();
        }
        res.add(image);
        blog.setImageList(res);
        imageRepository2.save(image);
        blogRepository.save(blog);
        return image;
//        Image image = new Image();
//        image.setDescription(description);
//        image.setDimensions(dimensions);
//        blog.getImageList().add(image);
//        blogRepository.save(blog);
//        imageRepository2.save(image);
//        return image;
    }

    public void deleteImage(Image image){
        imageRepository2.delete(image);
    }

    public Image findById(int id) {
        return imageRepository2.findById(id).get();
    }
    public void deleteImage(int id){
        deleteImage(imageRepository2.findById(id).get());
    }
    public int countImagesInScreen(Image image, String screenDimensions) {
        if (screenDimensions.split("X").length == 2 || Objects.nonNull(image)) {
            Integer maxLength = Integer.parseInt(screenDimensions.split("X")[0]) / Integer.parseInt(image.getDimensions().split("X")[0]) ;
            Integer maxBreadth = Integer.parseInt(screenDimensions.split("X")[1]) / Integer.parseInt(image.getDimensions().split("X")[1]);
            return maxLength * maxBreadth;
        }
        return 0;
    }
}
