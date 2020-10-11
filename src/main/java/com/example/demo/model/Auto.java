package com.example.demo.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "mark")
    private Mark mark;

    @ManyToOne()
    @JoinColumn(name = "model")
    private Model model;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "body_id")
//    private Body body;

    private int year;
    private int cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark.getMark_name();
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model.getModel_name();
    }

    public void setModel(Model model) {
        this.model = model;
    }

//    public Body getBody() {
//        return body;
//    }
//
//    public void setBody(Body body) {
//        this.body = body;
//    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
