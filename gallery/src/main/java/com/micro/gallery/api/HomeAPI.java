package com.micro.gallery.api;

import com.micro.gallery.entity.GalleryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
public class HomeAPI {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public GalleryEntity getGallery(@PathVariable final int id) {
        // create gallery object
        GalleryEntity gallery = new GalleryEntity();
        gallery.setId(id);

        // get list of available images
        List<Object> images = restTemplate.getForObject("http://products-service/api/products/images/", List.class);
        gallery.setImages(images);

        return gallery;
    }
}
