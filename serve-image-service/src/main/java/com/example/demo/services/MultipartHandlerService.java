package com.example.demo.services;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MultipartHandlerService {

	 private final Path root = Paths.get("src/main/resources/uploads");


	  @PostConstruct
	  public void init() {
		  
		  if(!Files.exists(root)) {
		   try {
	      Files.createDirectory(root);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not initialize folder for upload!");
	    }
	  }else {
		  System.out.println("Directory Exisits");
	  }
	  }

	  
	  public void save(MultipartFile file) {
		  
		 
	    try {
	      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
	    } catch (Exception e) {
	      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	    }
	  }

	  public Resource load(String filename) {
	    try {
	      Path file = root.resolve(filename);
	      Resource resource = new UrlResource(file.toUri());

	      if (resource.exists() || resource.isReadable()) {
	        return resource;
	      } else {
	        throw new RuntimeException("Could not read the file!");
	      }
	    } catch (MalformedURLException e) {
	      throw new RuntimeException("Error: " + e.getMessage());
	    }
	  }

	  public void deleteAll() {
	    FileSystemUtils.deleteRecursively(root.toFile());
	  }

	  public Stream<Path> loadAll() {
	    try {
	      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
	    } catch (IOException e) {
	      throw new RuntimeException("Could not load the files!");
	    }
	  }

	  }
