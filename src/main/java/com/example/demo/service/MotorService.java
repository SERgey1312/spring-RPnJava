package com.example.demo.service;

import com.example.demo.model.Motor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MotorService {
    List<Motor> getAllMotor();
    void saveMotor(String str);
}
