package com.myt.project.exception;

public class ServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String mensaje) {
		super(mensaje);
	}

}
