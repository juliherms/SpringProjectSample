package com.example.demo.exception;

import java.io.Serializable;

/**
 * This class custom expection
 * @author j.a.vasconcelos
 *
 */
public class ObjectNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String message) {
		super(message);
	}
	
}
