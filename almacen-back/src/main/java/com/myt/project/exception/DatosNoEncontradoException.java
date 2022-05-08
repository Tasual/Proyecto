package com.myt.project.exception;

public class DatosNoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatosNoEncontradoException(String mensaje) {
		super(mensaje);
	}
	
	public DatosNoEncontradoException(String mensaje, Throwable causas) {
		super(mensaje, causas);
	}

}
