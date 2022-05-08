package com.myt.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myt.project.exception.DatosNoEncontradoException;
import com.myt.project.model.Producto;
import com.myt.project.model.dto.Mensaje;
import com.myt.project.service.IProductoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductoController {

	@Autowired
	private IProductoService iProductoService;

	@GetMapping("/listar")
	public ResponseEntity<Mensaje> listarProductos() throws DatosNoEncontradoException {
		return new ResponseEntity<Mensaje>(iProductoService.listarProductos(), HttpStatus.OK);
	}

	@GetMapping("/listar/{nombre}")
	public ResponseEntity<Mensaje> filtrarProductos(@PathVariable String nombre) {
		return new ResponseEntity<Mensaje>(iProductoService.filtrarProductos(nombre), HttpStatus.OK);
	}

	@PostMapping("/insertar")
	public ResponseEntity<Mensaje> insertarProducto(@RequestBody Producto producto) {
		return new ResponseEntity<Mensaje>(iProductoService.insertarProducto(producto), HttpStatus.CREATED);
	}

	@DeleteMapping ("/eliminar/{id}")
	public ResponseEntity<Mensaje> eliminarProducto(@PathVariable long id) {
		
		return new ResponseEntity<Mensaje>(iProductoService.eliminarProducto(id), HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<Mensaje> actualizarProducto(@RequestBody Producto producto) {

		return new ResponseEntity<Mensaje>(iProductoService.actualizarProducto(producto), HttpStatus.CREATED);
	}
}
