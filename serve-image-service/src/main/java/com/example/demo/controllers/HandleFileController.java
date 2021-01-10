package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.example.demo.model.FileInfo;
import com.example.demo.services.MultipartHandlerService;



@RestController
public class HandleFileController {

	  @Autowired
	  MultipartHandlerService storageService;

	  

	  @PostMapping("/upload")
	  public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
	    String message = "";
	    try {
	      storageService.save(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(message);
	    } catch (Exception e) {
	    	e.printStackTrace();
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	    }
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<FileInfo>> getListFiles() {
	    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(HandleFileController.class, "getFile", path.getFileName().toString()).build().toString();

	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }

	  @GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = storageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }

	  @GetMapping(path = "/photo",produces = MediaType.IMAGE_JPEG_VALUE)
	    public ResponseEntity<byte[]> getImage() throws IOException {
	       ClassPathResource imgFile = new ClassPathResource("uploads/jpa.jpg");
	       
	        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.IMAGE_JPEG)
	                .body(bytes);
	    }

}
