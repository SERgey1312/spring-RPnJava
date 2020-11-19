package com.example.demo.service;


import com.example.demo.model.Auto;
import com.example.demo.model.Mark;
import com.example.demo.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Auto getAutoById(long id){
        return autoRepository.getOne(id);
    }

    @Override
    public List<Auto> getAutoByMark(long id) {
        return autoRepository.findByMark_Id(id);
    }

    @Override
    public List<Auto> getAutoByModel(long id) {
        return autoRepository.findByModel_Id(id);
    }

    @Override
    public List<Auto> sortByCost(List<Auto> autos, String sortP) {
        List<Auto> sortedList = autos.stream().sorted(Comparator.comparing(Auto::getCost)).collect(Collectors.toList());
        if (sortP.equals("DSC")){
            Collections.reverse(sortedList);
        }
        return sortedList;
    }

    @Override
    public List<Auto> sortByYear(List<Auto> autos, String sortY) {
        List<Auto> sortedList = autos.stream().sorted(Comparator.comparing(Auto::getYear)).collect(Collectors.toList());
        if (sortY.equals("DSC")){
            Collections.reverse(sortedList);
        }
        return sortedList;
    }

    @Override
    public List<Auto> getAutoByAllParam(long idMark, long idModel, long idBody, long idMotor, long idTrans) {
        return autoRepository.findByMark_IdAndModel_IdAndBody_IdAndMotor_IdAndTransmission_Id(idMark, idModel, idBody, idMotor, idTrans);
    }

    @Override
    public List<Auto> getAutoByMarkBodyMotorTrans(long idMark, long idBody, long idMotor, long idTrans) {
        return autoRepository.findByMark_IdAndBody_IdAndMotor_IdAndTransmission_Id(idMark, idBody, idMotor, idTrans);
    }

    @Override
    public List<Auto> getAutoByMarkModelMotorTrans(long idMark, long idModel, long idMotor, long idTrans) {
        return autoRepository.findByMark_IdAndModel_IdAndMotor_IdAndTransmission_Id(idMark, idModel, idMotor, idTrans);
    }

    @Override
    public List<Auto> getAutoByMarkModelBodyTrans(long idMark, long idModel, long idBody, long idTrans) {
        return autoRepository.findByMark_IdAndModel_IdAndBody_IdAndTransmission_Id(idMark, idModel, idBody, idTrans);
    }

    @Override
    public List<Auto> getAutoByMarkModelBodyMotor(long idMark, long idModel, long idBody, long idMotor) {
        return autoRepository.findByMark_IdAndModel_IdAndBody_IdAndMotor_Id(idMark,idModel,idBody,idMotor);
    }

    @Override
    public List<Auto> getAutoByBodyMotorTrans(long idBody, long idMotor, long idTrans) {
        return autoRepository.findByBody_IdAndMotor_IdAndTransmission_Id(idBody,idMotor, idTrans);
    }

    @Override
    public List<Auto> getAutoByMarkBodyMotor(long idMark, long idBody, long idMotor) {
        return autoRepository.findByMark_IdAndBody_IdAndMotor_Id(idMark, idBody, idMotor);
    }

    @Override
    public List<Auto> getAutoByMarkTransMotor(long idMark, long idTrans, long idMotor) {
        return autoRepository.findByMark_IdAndTransmission_IdAndMotor_Id(idMark, idTrans, idMotor);
    }

    @Override
    public List<Auto> getAutoByMarkBodyTrans(long idMark, long idBody, long idTrans) {
        return autoRepository.findByMark_IdAndBody_IdAndTransmission_Id(idMark, idBody, idTrans);
    }

    @Override
    public List<Auto> getAutoByMarkModelMotor(long idMark, long idModel, long idMotor) {
        return autoRepository.findByMark_IdAndModel_IdAndMotor_Id(idMark, idModel, idMotor);
    }

    @Override
    public List<Auto> getAutoByMarkModelTrans(long idMark, long idModel, long idTrans) {
        return autoRepository.findByMark_IdAndModel_IdAndTransmission_Id(idMark, idModel, idTrans);
    }

    @Override
    public List<Auto> getAutoByMarkModelBody(long idMark, long idModel, long idBody) {
        return autoRepository.findByMark_IdAndModel_IdAndBody_Id(idMark, idModel, idBody);
    }

    @Override
    public List<Auto> getAutoByTransMotor(long idTrans, long idMotor) {
        return autoRepository.findByTransmission_IdAndMotor_Id(idTrans, idMotor);
    }

    @Override
    public List<Auto> getAutoByBodyTrans(long idBody, long idTrans) {
        return autoRepository.findByBody_IdAndTransmission_Id(idBody, idTrans);
    }

    @Override
    public List<Auto> getAutoByBodyMotor(long idBody, long idMotor) {
        return autoRepository.findByBody_IdAndMotor_Id(idBody, idMotor);
    }

    @Override
    public List<Auto> getAutoByMarkMotor(long idMark, long idMotor) {
        return autoRepository.findByMark_IdAndMotor_Id(idMark, idMotor);
    }

    @Override
    public List<Auto> getAutoByMarkTrans(long idMark, long idTrans) {
        return autoRepository.findByMark_IdAndTransmission_Id(idMark, idTrans);
    }

    @Override
    public List<Auto> getAutoByMarkBody(long idMark, long idBody) {
        return autoRepository.findByMark_IdAndBody_Id(idMark, idBody);
    }

    @Override
    public List<Auto> getAutoByMarkModel(long idMark, long idModel) {
        return autoRepository.findByMark_IdAndModel_Id(idMark, idModel);
    }

    @Override
    public List<Auto> getAutoByBody(long idBody) {
        return autoRepository.findByBody_Id(idBody);
    }

    @Override
    public List<Auto> getAutoByTrans(long idTrans) {
        return autoRepository.findByTransmission_Id(idTrans);
    }

    @Override
    public List<Auto> getAutoByMotor(long idMotor) {
        return autoRepository.findByMotor_Id(idMotor);
    }

    @Override
    public List<Auto> getAutoByPriceMin(List<Auto> autoList, int min) {
        List<Auto> autos = new ArrayList<>();
        for(Auto auto : autoList){
            if (auto.getCost() > min){
                autos.add(auto);
            }
        }
        return autos;
    }

    @Override
    public List<Auto> getAutoByPriceMax(List<Auto> autoList, int max) {
        List<Auto> autos = new ArrayList<>();
        for (Auto auto : autoList){
            if (auto.getCost() < max){
                autos.add(auto);
            }
        }
        return autos;
    }

    @Override
    public List<Auto> getAutoByPriceBetweenMinMax(List<Auto> autoList, int min, int max) {
        List<Auto> autos = new ArrayList<>();
        for (Auto auto : autoList){
            if (auto.getCost() > min && auto.getCost() <= max){
                autos.add(auto);
            }
        }
        return autos;
    }

    @Override
    public List<Auto> getAutoByYearMin(List<Auto> autoList, int min) {
        List<Auto> autos = new ArrayList<>();
        for (Auto auto : autoList){
            if (auto.getYear() > min){
                autos.add(auto);
            }
        }
        return autos;
    }

    @Override
    public List<Auto> getAutoByYearMax(List<Auto> autoList, int max) {
        List<Auto> autos = new ArrayList<>();
        for (Auto auto : autoList){
            if (auto.getYear() < max){
                autos.add(auto);
            }
        }
        return autos;
    }

    @Override
    public List<Auto> getAutoByYearMinMax(List<Auto> autoList, int min, int max) {
        List<Auto> autos = new ArrayList<>();
        for (Auto auto : autoList){
            if (auto.getYear() > min && auto.getYear() <= max){
                autos.add(auto);
            }
        }
        return autos;
    }

}

