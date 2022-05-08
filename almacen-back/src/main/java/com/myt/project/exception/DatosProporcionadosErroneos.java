package com.myt.project.exception;

public class DatosProporcionadosErroneos extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatosProporcionadosErroneos(String mensaje) {
		super(mensaje);
	}
	
	public DatosProporcionadosErroneos(String mensaje, Throwable causas) {
		super(mensaje, causas);
	}

}
