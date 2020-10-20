package com.example.demo.service;

import com.example.demo.model.Transmission;
import com.example.demo.repository.TransmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransmissionServiceImpl implements TransmissionService {
    @Autowired
    TransmissionRepository transmissionRepository;

    @Override
    public List<Transmission> getAllTransmission() {
        return transmissionRepository.findAll();
    }

    @Override
    public void saveTransmission(String str) {
        Transmission transmission = new Transmission();
        transmission.setTransmission_type(str);
        transmissionRepository.save(transmission);
    }
}
