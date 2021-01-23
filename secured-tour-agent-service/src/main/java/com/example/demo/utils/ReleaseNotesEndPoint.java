package com.example.demo.utils;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@WebEndpoint(id="notes")
public class ReleaseNotesEndPoint {

	
	private HashMap<String, String> noteList;

	public ReleaseNotesEndPoint() {
		super();
		
		noteList= new HashMap<>();
		noteList.put("version", "1.0");
		noteList.put("year", "2021-22");
	}
	
	
	
	@ReadOperation
	public HashMap<String, String> getNotes(){
		
		return this.noteList;
	}
	
	@WriteOperation
	public HashMap<String, String> getUpdatedNotes(String key,String value){
		
		 noteList.put(key,value);
		 
		return this.noteList;
	}
}
