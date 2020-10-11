package com.example.demo.service;


import com.example.demo.model.Auto;
import com.example.demo.model.Mark;
import com.example.demo.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepository autoRepository;

    public List<Auto> getAllAuto(){
        return autoRepository.findAll();
    }

    @Override
    public void saveAuto(Auto auto, Mark mark){
        auto.setMark(mark);
        autoRepository.save(auto);
    }

    @Override
    public void deleteAutoById(long id){ autoRepository.deleteById(id);
    }

}

