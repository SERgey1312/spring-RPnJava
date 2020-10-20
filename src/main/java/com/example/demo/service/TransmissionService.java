package com.example.demo.service;

import com.example.demo.model.Transmission;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransmissionService {
    List<Transmission> getAllTransmission();
    void saveTransmission(String str);
}
