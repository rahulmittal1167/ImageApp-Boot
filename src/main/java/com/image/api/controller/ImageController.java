package com.image.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.image.api.entity.Image;
import com.image.api.service.ImageService;

@RestController
@CrossOrigin
public class ImageController {
	
	@Autowired
	ImageService imageService;

    @PostMapping(("/upload"))
	public String uploadFile(@RequestParam("file") MultipartFile  file) throws IOException {
    	System.out.println(" InController");
    	imageService.store(file);
    	System.out.println(" InController");
		return "Success";
	}
    
    @GetMapping("/files")
	public List<Image> getAll() {
		return imageService.findAllImages();
	}
    
    @GetMapping("/get/{imageName}")
	public Image getImage(@PathVariable("imageName") String imageName) throws IOException {

		final Optional<Image> retrievedImage = imageService.nameSearch(imageName);
		Image img = new Image(retrievedImage.get().getId(),retrievedImage.get().getName(), retrievedImage.get().getType(),retrievedImage.get().getData());
		return img;
	}
    
    @GetMapping("/show/{id}")
	public Image getImageById(@PathVariable("id") String id) throws IOException {

		final Optional<Image> retrievedImage = imageService.idSearch(id);
		Image img = new Image(retrievedImage.get().getId(),retrievedImage.get().getName(), retrievedImage.get().getType(),retrievedImage.get().getData());
		return img;
	}
}
