package com.example.demo.service;

import com.example.demo.model.Auto;
import com.example.demo.model.Mark;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarkService {
    List<Mark> getAllMark();
    void saveMark(String str);
}
