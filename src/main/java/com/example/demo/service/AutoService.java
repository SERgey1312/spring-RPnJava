package com.example.demo.service;

import com.example.demo.model.Auto;
import com.example.demo.model.Mark;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AutoService {
    List<Auto> getAllAuto();
    void saveAuto(Auto auto, Mark mark);
    void deleteAutoById(long id);
    Auto getAutoById(long id);
    List<Auto> getAutoByMark(long id);
    List<Auto> getAutoByModel(long id);
    List<Auto> sortByCost(List<Auto> autos, String sortP);
    List<Auto> sortByYear(List<Auto> autos, String sortY);
    List<Auto> getAutoByAllParam(long idMark,long idModel,long idBody,long idMotor,long idTrans);
    List<Auto> getAutoByMarkBodyMotorTrans(long idMark,long idBody,long idMotor, long idTrans);
    List<Auto> getAutoByMarkModelMotorTrans(long idMark,long idModel,long idMotor, long idTrans);
    List<Auto> getAutoByMarkModelBodyTrans(long idMark,long idModel,long idBody, long idTrans);
    List<Auto> getAutoByMarkModelBodyMotor(long idMark,long idModel,long idBody,long idMotor);
    List<Auto> getAutoByBodyMotorTrans(long idBody,long idMotor, long idTrans);
    List<Auto> getAutoByMarkBodyMotor(long idMark, long idBody, long idMotor);
    List<Auto> getAutoByMarkTransMotor(long idMark, long idTrans, long idMotor);
    List<Auto> getAutoByMarkBodyTrans(long idMark, long idBody, long idTrans);
    List<Auto> getAutoByMarkModelMotor (long idMark, long idModel, long idMotor);
    List<Auto> getAutoByMarkModelTrans(long idMark, long idModel, long idTrans);
    List<Auto> getAutoByMarkModelBody(long idMark, long idModel, long idBody);
    List<Auto> getAutoByTransMotor(long idTrans, long idMotor);
    List<Auto> getAutoByBodyTrans(long idBody, long idTrans);
    List<Auto> getAutoByBodyMotor(long idBody, long idMotor);
    List<Auto> getAutoByMarkMotor(long idMark, long idMotor);
    List<Auto> getAutoByMarkTrans(long idMark, long idTrans);
    List<Auto> getAutoByMarkBody(long idMark, long idBody);
    List<Auto> getAutoByMarkModel(long idMark, long idModel);
    List<Auto> getAutoByBody(long idBody);
    List<Auto> getAutoByTrans(long idTrans);
    List<Auto> getAutoByMotor(long idMotor);
    List<Auto> getAutoByPriceMin(List<Auto> autoList,int min);
    List<Auto> getAutoByPriceMax(List<Auto> autoList, int max);
    List<Auto> getAutoByPriceBetweenMinMax(List<Auto> autoList, int min, int max);
    List<Auto> getAutoByYearMin(List<Auto> autoList, int min);
    List<Auto> getAutoByYearMax(List<Auto> autoList, int max);
    List<Auto> getAutoByYearMinMax(List<Auto> autoList, int min, int max);
}
