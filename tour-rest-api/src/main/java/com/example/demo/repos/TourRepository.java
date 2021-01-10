package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

	public Tour findByTourName(String tourName);
	
	@Query(nativeQuery = true,value = "Select * from synetours where amount>:srchValue")
	public List<Tour> findTourGreathanFare(@Param("srchValue") double fare);
	
}
