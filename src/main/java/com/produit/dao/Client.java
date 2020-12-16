package com.produit.dao;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.produit.web.exception.Helper;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "client",
uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }, 
name = "clie_email"),@UniqueConstraint(columnNames = { "phoneNumber" }, 
name = "clie_phone") })

public class Client  implements Comparable<Client>{

	@Id  @GeneratedValue
	@Column(name="client_id")
	Long id;
	
	@Size(min = 3, max = 15, message = Helper.MESSAGE_EXCEPTION_SIZE)
	@NotEmpty(message = Helper.MESSAGE_EXCEPTION_NOT_EMPTY)
	String firstname;
	
	//@Size(min = 3, max = 15, message = Helper.MESSAGE_EXCEPTION_SIZE)
	//@NotEmpty(message =  Helper.MESSAGE_EXCEPTION_NOT_EMPTY)
	String lastname;
	
	@Size(min = 10, max = 40, message = Helper.MESSAGE_EXCEPTION_SIZE)
	@NotEmpty(message =  Helper.MESSAGE_EXCEPTION_NOT_EMPTY)
	@Email(message = Helper.MESSAGE_EXCEPTION_EMAIL_FORMAT)
	String email;
	
	//@NotNull(message = Helper.MESSAGE_EXCEPTION_NOT_NULL)
	//@JsonFormat(pattern = Helper.PATTERN_DATE_FORMAT)
	//Date registerDate ;
	
	@Size(min = 5, message = Helper.MESSAGE_EXCEPTION_SIZE)
	@NotEmpty(message =  Helper.MESSAGE_EXCEPTION_NOT_EMPTY)
	String address;
	
	String zipcode;
	
	String city;
	
	@NotNull(message = Helper.MESSAGE_EXCEPTION_NOT_NULL)
	@Pattern(regexp = Helper.PATTERN_PHONE_FORMAT, message =Helper.MESSAGE_EXCEPTION_PHONE_NUMBER_FORMAT)
	String  phoneNumber;

	// for sort
	@Override
	public int compareTo(Client client) {
		return id.compareTo(client.getId());
	}
	
	
}
