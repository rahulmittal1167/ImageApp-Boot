package com.image.api.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.image.api.entity.Image;

public interface ImageService {

	 public void store(MultipartFile file) throws IOException;

	public Optional<Image> nameSearch(String imageName);

	public Optional<Image> idSearch(String imageName);
	
	public List<Image> findAllImages();
}
