package com.example.demo.service;

import com.example.demo.model.Body;
import com.example.demo.repository.BodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyServiceImpl implements BodyService {

    @Autowired
    BodyRepository bodyRepository;

    @Override
    public List<Body> getAllBody() {
        return bodyRepository.findAll();
    }

    @Override
    public void saveBody(String str) {
        Body body = new Body();
        body.setBody_name(str);
        bodyRepository.save(body);
    }
}
