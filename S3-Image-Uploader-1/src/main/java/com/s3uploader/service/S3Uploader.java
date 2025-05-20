package com.s3uploader.service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;

@Service
public class S3Uploader implements ImageUploader {
	
	@Autowired
	private AmazonS3 client;
	
	@Value("${app.s3.bucket}")
	private String s3BucketName;
	
	@Value("${cloud.aws.credentials.access-key}")
	private String accessKey;

	@Override
	public String uploadImage(MultipartFile image) throws IOException  {
		String actualFileName = image.getOriginalFilename();
		String modifiedFileName = UUID.randomUUID().toString()+actualFileName.substring(actualFileName.lastIndexOf("."));
		
		ObjectMetadata objectMetaData = new ObjectMetadata();
		objectMetaData.setContentLength(image.getSize());
		
//		long fileSize = image.getSize();
		
		PutObjectRequest putObjectequest = null;
		try {
			putObjectequest = new PutObjectRequest(s3BucketName, modifiedFileName, image.getInputStream(), objectMetaData);
		} catch (IOException e) {

			e.printStackTrace();
		}

		PutObjectResult putObjectResult = client.putObject(putObjectequest);	
		
		return modifiedFileName;
	}

}
