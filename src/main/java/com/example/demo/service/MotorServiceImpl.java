package com.example.demo.service;

import com.example.demo.model.Motor;
import com.example.demo.repository.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorServiceImpl implements MotorService {

    @Autowired
    MotorRepository motorRepository;

    @Override
    public List<Motor> getAllMotor() {
        return motorRepository.findAll();
    }

    @Override
    public void saveMotor(String str) {
        Motor motor = new Motor();
        motor.setMotor_type(str);
        motorRepository.save(motor);
    }
}
