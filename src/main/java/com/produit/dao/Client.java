package com.produit.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {

	@Id  @GeneratedValue
	@Column(name="client_id")
	Long id;
	String firstname;
	String lastname;
	String email;
	Date registerDate ;
	String address;
	String zipcode;
	String city;
	int phoneNumber;
	
	
}
