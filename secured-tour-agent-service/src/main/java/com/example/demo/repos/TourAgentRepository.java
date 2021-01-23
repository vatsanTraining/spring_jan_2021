package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TourAgent;

public interface TourAgentRepository extends JpaRepository<TourAgent, Integer> {

}
