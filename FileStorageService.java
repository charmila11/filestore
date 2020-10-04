package com.example.demo.service;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.util.stream.Stream;

import com.example.demo.file.Documents;
import com.example.demo.filerepository.FileRepository;

@Service
public class FileStorageService {

	@Autowired
	private FileRepository fileRepository;

	public Documents store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    System.out.println(fileName + "," + file.getContentType() + "," + file.getBytes());
	    Documents File = new Documents(fileName, file.getContentType(), file.getBytes());

	    return fileRepository.save(File);
	  }

	  public Documents getFile(String id) {
	    return fileRepository.findById(id).get();
	  }
	  
	  public Stream<Documents> getAllFiles() {
	    return fileRepository.findAll().stream();
	  }
	
}
