package com.s3uploader.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploader {
	
	public String uploadImage(MultipartFile image) throws IOException;
}
