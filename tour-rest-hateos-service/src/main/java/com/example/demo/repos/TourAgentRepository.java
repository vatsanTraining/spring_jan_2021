package com.example.demo.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.model.Tour;
import com.example.demo.model.TourAgent;


@RepositoryRestResource
public interface TourAgentRepository extends JpaRepository<TourAgent, Integer> {

	
	@RestResource(path="agents")
	public List<TourAgent> findByAgentName(String name);

}
