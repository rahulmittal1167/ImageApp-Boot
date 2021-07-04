package com.image.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.image.api.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
	
	Optional<Image> findByName(String name);

}
