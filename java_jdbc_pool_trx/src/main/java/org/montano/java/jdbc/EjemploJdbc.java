package org.montano.java.jdbc;

import org.montano.java.jdbc.modelo.*;
import org.montano.java.jdbc.servicio.*;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        Servicio servicio = new CatalogoServicio();

        System.out.println("============ LISTAR ==================");
        servicio.listar().forEach(System.out::println);

        System.out.println("============ INSERTAR CATEGORIA ==================");
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");
        System.out.println("Categoria insertada con exito " + categoria.getId());


        System.out.println("============ LISTAR CATEGORIAS ==================");
        servicio.listarCategoria().forEach(System.out::println);


        System.out.println("============ INSERTAR PRODUCTO ==================");
        Producto producto = new Producto();
        producto.setNombre("Lampara led escritorio");
        producto.setPrecio(40.70F);
        producto.setFechaRegistro(new Date());
        servicio.guardarProductoConCategoria(producto, categoria);
        System.out.println("producto agregado con exito "+ producto.getId());

        System.out.println("============ LISTAR ==================");
        servicio.listar().forEach(System.out::println);
    }
}
