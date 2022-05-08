package com.myt.project.service;

import com.myt.project.model.Producto;
import com.myt.project.model.dto.Mensaje;

public interface IProductoService {

	public Mensaje listarProductos();

	public Mensaje filtrarProductos(String nombre);

	public Mensaje insertarProducto(Producto producto);

	public Mensaje eliminarProducto(long id);

	public Mensaje actualizarProducto(Producto producto);
}
