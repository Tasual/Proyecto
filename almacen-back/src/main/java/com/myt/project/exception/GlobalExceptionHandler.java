package com.myt.project.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.myt.project.model.dto.Mensaje;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public Mensaje ServiceException(ServiceException ex, WebRequest request) {
		Mensaje mensaje = new Mensaje();
		mensaje.setCodigoSistema(-1);
		mensaje.setCodigoUsuario(-1);
		mensaje.setMensajeSistema(ex.getMessage());
		mensaje.setMensajeUsuario("Ha ocurrido un error durante la operación");
		mensaje.setContenido(new ArrayList<>());
		return mensaje;
	}
	
	@ExceptionHandler(DatosProporcionadosErroneos.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Mensaje badRequest(ServiceException ex, WebRequest request) {
		Mensaje mensaje = new Mensaje();
		mensaje.setCodigoSistema(-1);
		mensaje.setCodigoUsuario(-1);
		mensaje.setMensajeSistema(ex.getMessage());
		mensaje.setMensajeUsuario(ex.getMessage());
		mensaje.setContenido(new ArrayList<>());
		return mensaje;
	}
}
