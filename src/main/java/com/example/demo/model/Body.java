package com.example.demo.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "body")
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String body_name;

    @OneToMany(mappedBy = "body")
    private Set<Auto> autos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody_name() {
        return body_name;
    }

    public void setBody_name(String body_name) {
        this.body_name = body_name;
    }

    public Set<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Set<Auto> autos) {
        this.autos = autos;
    }
}
