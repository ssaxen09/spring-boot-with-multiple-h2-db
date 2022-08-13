package com.example.sprningboote.itcomp.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "email_address")
public class EmailAddress {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private Long Id;
	private String address;
}
