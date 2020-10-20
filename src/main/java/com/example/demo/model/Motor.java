package com.example.demo.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "motor")
public class Motor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String motor_type;

    @OneToMany(mappedBy = "motor")
    private Set<Auto> autos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotor_type() {
        return motor_type;
    }

    public void setMotor_type(String motor_type) {
        this.motor_type = motor_type;
    }

    public Set<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Set<Auto> autos) {
        this.autos = autos;
    }
}
