package com.example.demo.service;

import com.example.demo.model.Mark;
import com.example.demo.model.Model;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelService {
    List<Model> getAllModel();
    void saveNewModel(String str, Mark mark);
}
