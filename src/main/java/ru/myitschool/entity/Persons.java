package ru.myitschool.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Persons {

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}