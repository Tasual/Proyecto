package com.myt.project.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myt.project.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

	@Query(value = "SELECT * FROM productos", nativeQuery = true)
	ArrayList<Producto> listarProductos();

	@Query(value = "SELECT * FROM productos where nombre like '%:nombre%'", nativeQuery = true)
	ArrayList<Producto> filtrarProductos(@Param("nombre") String nombre);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO productos (id, nombre, descripcion, precio, cantidad, peso, imagen) "
			+ " values (:id, :nombre, :descripcion, :precio, :cantidad, :peso, :imagen)", nativeQuery = true)
	void insertarProducto(@Param("id") long id, @Param("nombre") String nombre,
			@Param("descripcion") String descripcion, @Param("precio") long precio, @Param("cantidad") long cantidad,
			@Param("peso") double peso, @Param("imagen") String imagen);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM productos WHERE id=:id", nativeQuery = true)
	void eliminarProducto(@Param("id") long id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE productos set  nombre = :nombre, descripcion = :descripcion, precio = :precio, cantidad = :cantidad, peso = :peso, imagen = :imagen"
			+ " where id = :id ", nativeQuery = true)
	void actualizaProducto(@Param(value = "id") long id, @Param( value = "nombre") String nombre,
			@Param(value = "descripcion") String descripcion, @Param(value = "precio") long precio, @Param(value = "cantidad") long cantidad,
			@Param(value = "peso") double peso, @Param(value = "imagen") String imagen);

}