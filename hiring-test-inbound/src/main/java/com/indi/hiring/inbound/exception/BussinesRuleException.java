package com.indi.hiring.inbound.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BussinesRuleException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
	private final long id;
    private final String code;   
    private final HttpStatus httpStatus;
    
     public BussinesRuleException(final long id, String code, String message,HttpStatus httpStatus) {
        super(message);
        this.id = id;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public BussinesRuleException(String code, String message,HttpStatus httpStatus) {
        super(message);
		this.id = 0;
        this.code = code;
        this.httpStatus = httpStatus;
    }
    
    public BussinesRuleException(String message, Throwable cause) {
		super(message, cause);
        this.id = 0;
		this.code = "";
		this.httpStatus = null;
    }     
    
}
