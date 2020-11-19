package com.example.demo.repository;

import com.example.demo.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto,Long> {
    List<Auto> findByMark_Id(long id);
    List<Auto> findByModel_Id(long id);
    List<Auto> findByBody_Id(long idBody);
    List<Auto> findByMotor_Id(long idMotor);
    List<Auto> findByTransmission_Id(long idTrans);
    List<Auto> findByMark_IdAndModel_Id(long idMark, long idModel);
    List<Auto> findByMark_IdAndBody_Id(long idMark, long idBody);
    List<Auto> findByMark_IdAndTransmission_Id(long idMark, long idTrans);
    List<Auto> findByMark_IdAndMotor_Id(long idMark, long idMotor);
    List<Auto> findByBody_IdAndMotor_Id(long idBody, long idMotor);
    List<Auto> findByBody_IdAndTransmission_Id(long idBody, long idTrans);
    List<Auto> findByTransmission_IdAndMotor_Id(long idTrans, long idMotor);
    List<Auto> findByMark_IdAndModel_IdAndBody_Id(long idMark, long idModel, long idBody);
    List<Auto> findByMark_IdAndModel_IdAndTransmission_Id(long idMark, long idModel, long idTrans);
    List<Auto> findByMark_IdAndModel_IdAndMotor_Id(long idMark, long idModel, long idMotor);
    List<Auto> findByMark_IdAndBody_IdAndTransmission_Id(long idMark, long idBody, long idTrans);
    List<Auto> findByMark_IdAndTransmission_IdAndMotor_Id(long idMark, long idTrans, long idMotor);
    List<Auto> findByMark_IdAndBody_IdAndMotor_Id(long idMark, long idBody, long idMotor);
    List<Auto> findByBody_IdAndMotor_IdAndTransmission_Id(long idBody,long idMotor, long idTrans);
    List<Auto> findByMark_IdAndModel_IdAndBody_IdAndMotor_Id(long idMark,long idModel,long idBody,long idMotor);
    List<Auto> findByMark_IdAndModel_IdAndBody_IdAndTransmission_Id(long idMark,long idModel,long idBody, long idTrans);
    List<Auto> findByMark_IdAndModel_IdAndMotor_IdAndTransmission_Id(long idMark,long idModel,long idMotor, long idTrans);
    List<Auto> findByMark_IdAndBody_IdAndMotor_IdAndTransmission_Id(long idMark,long idBody,long idMotor, long idTrans);
    List<Auto> findByMark_IdAndModel_IdAndBody_IdAndMotor_IdAndTransmission_Id(long idMark,long idModel,long idBody,long idMotor,long idTrans);

}