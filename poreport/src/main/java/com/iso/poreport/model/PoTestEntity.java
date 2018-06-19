package com.iso.poreport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="po_test_entity")
public class PoTestEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
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
	public PoTestEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public PoTestEntity() {
		super();
	}
	

}
