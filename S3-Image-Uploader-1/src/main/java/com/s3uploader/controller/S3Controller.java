package com.s3uploader.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.s3uploader.service.ImageUploader;

@RestController
@RequestMapping("/api/v1/s3")
public class S3Controller {
	
	@Autowired
	private ImageUploader imageUploader;
	
	public S3Controller(ImageUploader imageUploader) {
		this.imageUploader = imageUploader;
	}
	
	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam MultipartFile file) throws IOException{
		
		return ResponseEntity.ok(imageUploader.uploadImage(file));
		
	}

}