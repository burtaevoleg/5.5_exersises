package ru.myitschool.entity;


import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;


public class PhoneNumbers {
    private Integer id;
    private Long value;
    private Integer idPerson;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public Long getValue() {
        return value;
    }
 
    public void setValue(Long value) {
        this.value = value;
    }
 
    public Integer getIdPerson() {
        return idPerson;
    }
 
    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }
}