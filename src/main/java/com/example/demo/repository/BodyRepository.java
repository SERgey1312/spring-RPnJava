package com.example.demo.repository;

import com.example.demo.model.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyRepository extends JpaRepository<Body,Long> {
}

