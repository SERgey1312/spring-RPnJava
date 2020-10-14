package com.example.demo.service;

import com.example.demo.model.Auto;
import com.example.demo.model.Mark;

import java.util.List;

public interface AutoService {
    List<Auto> getAllAuto();
    void saveAuto(Auto auto, Mark mark);
    void deleteAutoById(long id);
    Auto getAutoById(long id);
}
