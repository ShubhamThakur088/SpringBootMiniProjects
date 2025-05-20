package com.s3uploader.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.s3uploader.config","com.s3uploader.controller","com.s3uploader.service"})
public class S3ImageUploader1Application {

	public static void main(String[] args) {
		SpringApplication.run(S3ImageUploader1Application.class, args);
	}

}
