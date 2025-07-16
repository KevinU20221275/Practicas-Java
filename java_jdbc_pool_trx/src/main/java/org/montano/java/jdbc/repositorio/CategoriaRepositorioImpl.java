package org.montano.java.jdbc.repositorio;

import org.montano.java.jdbc.modelo.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements Repositorio<Categoria>{
    private Connection conn;

    public CategoriaRepositorioImpl(){};

    public CategoriaRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM categorias");
        ){
            while (rs.next()){
                Categoria c = crearCategoria(rs);

                categorias.add(c);
            }
        }

        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;

        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categorias WHERE id=?")){
             stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    categoria = crearCategoria(rs);
                }
            }
        }

        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {
        String query = "";
        boolean isUpdate = (categoria.getId() != null) && (categoria.getId() > 0);

        if (isUpdate){
            query = "UPDATE categorias SET nombre=? WHERE id=?";
        } else {
            query = "INSERT INTO categorias (nombre) VALUES (?)";
        }

        try(PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, categoria.getNombre());

            if (isUpdate){
                stmt.setLong(2, categoria.getId());
            }

            stmt.executeUpdate();

            if (categoria.getId() == null){
                try (ResultSet rs = stmt.getGeneratedKeys()){
                    if (rs.next()){
                        categoria.setId(rs.getLong(1));
                    }
                }
            }
        }

        return categoria;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM categorias WHERE id = ?")){
            stmt.setLong(1, id);
            stmt.executeQuery();
        }

    }

    private static Categoria crearCategoria(ResultSet rs) throws SQLException {
        Categoria c = new Categoria();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));
        return c;
    }
}
