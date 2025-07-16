package org.montano.java.jdbc.repositorio;

import org.montano.java.jdbc.modelo.Categoria;
import org.montano.java.jdbc.modelo.Producto;
import org.montano.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{
    private Connection conn;

    public ProductoRepositorioImpl(){};

    public ProductoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("Select p.*, c.nombre as categoria from productos as p INNER JOIN categorias as c ON (p.categoria_id = c.id)")){

            while (rs.next()){
                Producto p = crearProducto(rs);

                productos.add(p);
            }
        }

        return productos;
    }


    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;

        try (PreparedStatement stmt = conn.prepareStatement("Select p.*, c.nombre as categoria from productos as p INNER JOIN categorias as c ON (p.categoria_id = c.id) where p.id = ?")){

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    producto = crearProducto(rs);
                }
            }
        }

        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        String sql;
        boolean isUpdate = (producto.getId() != null) && (producto.getId() > 0);

        if (isUpdate) {
            sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ? WHERE id = ?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, fecha_registro) VALUES (?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, producto.getNombre());
            stmt.setFloat(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());

            if (isUpdate){
                stmt.setLong(4, producto.getId());
            } else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
            }

            stmt.executeUpdate();

            if (!isUpdate){
                try (ResultSet rs = stmt.getGeneratedKeys()){
                    if (rs.next()){
                        producto.setId(rs.getLong(1));
                    }
                }
            }
        }

        return producto;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id =? ")){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getFloat("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }
}
