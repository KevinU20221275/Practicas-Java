package org.montano.java.jdbc;

import org.montano.java.jdbc.modelo.Categoria;
import org.montano.java.jdbc.modelo.Producto;
import org.montano.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.montano.java.jdbc.repositorio.Repositorio;
import org.montano.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        try(Connection conn = ConexionBaseDatos.getInstance()) {
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            try {


                Repositorio<Producto> repositorioProducto = new ProductoRepositorioImpl();
                System.out.println("============ LISTAR ==================");
                repositorioProducto.listar().forEach(System.out::println);

                System.out.println("============ BUSQUEDA POR ID ==================");
                System.out.println(repositorioProducto.porId(1L));

                System.out.println("============ INSERTAR PRODUCTO ==================");
                Producto producto = new Producto();
                producto.setNombre("Teclado mecanico");
                producto.setPrecio(500F);
                producto.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);


                repositorioProducto.guardar(producto);
                System.out.println("producto agregado con exito");

                System.out.println("============ LISTAR ==================");
                repositorioProducto.listar().forEach(System.out::println);

                System.out.println("============ UPDATE ==================");
                producto.setId(3L);
                producto.setNombre("Teclado Razer mecanico");
                producto.setPrecio(550F);
                categoria.setId(2L);
                producto.setCategoria(categoria);

                repositorioProducto.guardar(producto);
                System.out.println("producto actualizado con exito");

                System.out.println("============ LISTAR ==================");
                repositorioProducto.listar().forEach(System.out::println);


                System.out.println("============ ELIMINAR ==================");
                repositorioProducto.eliminar(producto.getId());

                System.out.println("============ LISTAR ==================");
                repositorioProducto.listar().forEach(System.out::println);

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        }
    }
}
