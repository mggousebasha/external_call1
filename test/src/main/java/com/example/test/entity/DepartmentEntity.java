package com.example.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DepartmentEntity {

	@Id
	private int  id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DepartmentEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public DepartmentEntity() {
		// TODO Auto-generated constructor stub
	}
	
}
