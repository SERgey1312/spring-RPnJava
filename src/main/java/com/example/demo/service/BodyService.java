package com.example.demo.service;

import com.example.demo.model.Body;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BodyService {
    List<Body> getAllBody();
    void saveBody(String str);
}
