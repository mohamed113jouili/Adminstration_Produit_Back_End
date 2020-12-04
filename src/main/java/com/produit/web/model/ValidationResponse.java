package com.produit.web.model;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor // constructor without param
@Getter
@Setter
public class ValidationResponse extends ApiResponse {

	List<String> subErrors;

	public ValidationResponse(HttpStatus status, String message, String comment, List<String> subErrors) {

		super(status, message, comment);
		this.subErrors = subErrors;

	}

	public ValidationResponse(HttpStatus status, String message, int type, String comment, List<String> subErrors) {

		super(status, message, type, comment);
		this.subErrors = subErrors;

	}

}