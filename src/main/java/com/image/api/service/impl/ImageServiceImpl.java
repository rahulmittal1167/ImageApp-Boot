package com.image.api.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.image.api.entity.Image;
import com.image.api.repository.ImageRepository;
import com.image.api.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{

	private ImageRepository imageRepository;
	
	public ImageServiceImpl(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}

	@Override
	public void store(MultipartFile file) throws IOException {
		System.out.println(" InController");
		String fileName = file.getOriginalFilename();
		Image fileDb = new Image(UUID.randomUUID().toString(), fileName, file.getContentType(), file.getBytes());
		System.out.println(fileName + " " + file.getContentType() + " " + file.getBytes());
	    imageRepository.save(fileDb);
	}

	@Override
	public Optional<Image> nameSearch(String imageName) {
		return imageRepository.findByName(imageName);
	}

	@Override
	public Optional<Image> idSearch(String id) {
		return imageRepository.findById(id);
	}

	@Override
	public List<Image> findAllImages() {
		return imageRepository.findAll();
	}

}
