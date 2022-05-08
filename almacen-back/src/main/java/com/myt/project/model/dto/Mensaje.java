package com.myt.project.model.dto;

public class Mensaje {

	private int codigoUsuario;
	private int codigoSistema;
	private Object contenido;
	private String mensajeUsuario;
	private String mensajeSistema;

	public Mensaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mensaje(Object contenido, String mensajeUsuario, String mensajeSistema) {
		this.codigoSistema = 0;
		this.codigoUsuario = 0;
		this.contenido = contenido;
		this.mensajeUsuario = mensajeUsuario;
		this.mensajeSistema = mensajeSistema;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Object getContenido() {
		return contenido;
	}

	public void setContenido(Object contenido) {
		this.contenido = contenido;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}

	public int getCodigoSistema() {
		return codigoSistema;
	}

	public void setCodigoSistema(int codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	public String getMensajeSistema() {
		return mensajeSistema;
	}

	public void setMensajeSistema(String mensajeSistema) {
		this.mensajeSistema = mensajeSistema;
	}

	@Override
	public String toString() {
		return "Mensaje [codigoUsuario=" + codigoUsuario + ", codigoSistema=" + codigoSistema + ", contenido="
				+ contenido + ", mensajeUsuario=" + mensajeUsuario + ", mensajeSistema=" + mensajeSistema + "]";
	}

}
