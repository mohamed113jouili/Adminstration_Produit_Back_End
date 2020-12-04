package com.produit.web.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomNullPointException extends NullPointerException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mesage;
    private int type;
    private String comment ;
	public CustomNullPointException(String mesage, int type, String comment) {
		super();
		this.mesage = mesage;
		this.type = type;
		this.comment = comment;
		
		
	}
    
    
    

}
