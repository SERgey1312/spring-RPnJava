package com.example.demo.service;

import com.example.demo.model.Mark;
import com.example.demo.model.Model;
import com.example.demo.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelRepository modelRepository;

    @Override
    public List<Model> getAllModel() {
        return modelRepository.findAll();
    }

    @Override
    public void saveNewModel(String str, Mark mark) {
        Model madel = new Model();
        madel.setModel_name(str);
        madel.setMark(mark);
        modelRepository.save(madel);
    }
}
