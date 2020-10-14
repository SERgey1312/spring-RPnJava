package com.example.demo.service;

import com.example.demo.model.Mark;
import com.example.demo.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    MarkRepository markRepository;

    @Override
    public List<Mark> getAllMark() {
        return markRepository.findAll();
    }

    @Override
    public void saveMark(String str) {
        Mark mark = new Mark();
        mark.setMark_name(str);
        markRepository.save(mark);
    }
}
