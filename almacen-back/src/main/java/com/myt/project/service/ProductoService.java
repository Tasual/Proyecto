package com.myt.project.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myt.project.exception.DatosProporcionadosErroneos;
import com.myt.project.exception.ServiceException;
import com.myt.project.model.Producto;
import com.myt.project.model.dto.Mensaje;
import com.myt.project.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;

	private String mensajeUsuario = "Operación realizada con éxito";
	private String mensajeSistema = "Operación realizada con éxito";

	@Override
	@Transactional(readOnly = true)
	public Mensaje listarProductos() throws ServiceException {
		Mensaje mensaje = null;
		try {
			ArrayList<Producto> productos = iProductoRepository.listarProductos();

			if (productos != null && productos.size() < 1) {
				mensajeUsuario = "No se han encontrado datos";
				mensajeSistema = "No se han encontrado datos";
			}

			mensaje = new Mensaje(productos, mensajeUsuario, mensajeSistema);

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return mensaje;
	}

	@Override
	@Transactional(readOnly = true)
	public Mensaje filtrarProductos(String nombre) throws ServiceException {
		Mensaje mensaje = null;
		try {
			ArrayList<Producto> productos = iProductoRepository.filtrarProductos(nombre);

			if (productos != null && productos.size() < 1) {
				mensajeUsuario = "No se han encontrado datos";
				mensajeSistema = "No se han encontrado datos";
			}

			mensaje = new Mensaje(productos, mensajeUsuario, mensajeSistema);

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return mensaje;
	}

	@Override
	@Transactional()
	public Mensaje insertarProducto(Producto producto) throws ServiceException {
		Date date = new Date();
		long msec = date.getTime();

		Mensaje mensaje = null;
		try {

			if (producto != null && producto.getImagen() != null
					&& producto.getNombre() != null && !producto.getNombre().isEmpty()
					&& producto.getDescripcion() != null && !producto.getDescripcion().isEmpty()) {
				
				iProductoRepository.insertarProducto(msec, producto.getNombre(), producto.getDescripcion(),
						producto.getPrecio(), producto.getCantidad(), producto.getPeso(), producto.getImagen());

				mensaje = new Mensaje(new ArrayList<>(), mensajeUsuario, mensajeSistema);
			} else {
				throw new DatosProporcionadosErroneos("los datos proporcionados son erroneos");
			}
			

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		
		return mensaje;

	}

	@Override
	@Transactional()
	public Mensaje eliminarProducto(long id) throws ServiceException {

		Mensaje mensaje = new Mensaje();
		try {

			iProductoRepository.eliminarProducto(id);

			mensaje = new Mensaje(new ArrayList<>(), mensajeUsuario, mensajeSistema);

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return mensaje;
	}

	@Override
	@Transactional()
	public Mensaje actualizarProducto(Producto producto) throws ServiceException {

		Mensaje mensaje = new Mensaje();
		try {

			iProductoRepository.actualizaProducto(producto.getId(), producto.getNombre(), producto.getDescripcion(),
					producto.getPrecio(), producto.getCantidad(), producto.getPeso(), producto.getImagen());

			mensaje = new Mensaje(new ArrayList<>(), mensajeUsuario, mensajeSistema);

		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return mensaje;
	}

}
