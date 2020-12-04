package com.produit.web.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor // constructor without param
@Getter
@Setter
public class ApiResponse extends ApiSubError {
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private int type;
	private String comment;
	

	public ApiResponse(HttpStatus status, String message, String comment) {
		timestamp = LocalDateTime.now();
		this.status = status;
		this.message = message;
		this.comment = comment;
		

	}

	public ApiResponse(HttpStatus status, String message, int type, String comment) {
		timestamp = LocalDateTime.now();
		this.status = status;
		this.message = message;
		this.type = type;
		this.comment = comment;

	}

}
