package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity(name = "girl")
public class Girlaaa {
    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;

    private String name;

    @Min(value = 18, message = "wei cheng nian")
    private Integer age;

    public Girlaaa() {
    }

    public Integer getId() {
        return id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
