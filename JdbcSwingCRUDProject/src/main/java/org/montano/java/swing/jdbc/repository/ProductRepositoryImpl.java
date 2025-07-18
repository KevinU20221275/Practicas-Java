package org.montano.java.swing.jdbc.repository;

import org.montano.java.swing.jdbc.db.ConnectionJdbc;
import org.montano.java.swing.jdbc.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try(Connection conn = ConnectionJdbc.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products")){

            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));

                products.add(p);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public Product fintById(Long id) {
        Product product = null;

        try(Connection conn = ConnectionJdbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE id = ?")
            ){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    product.setId(rs.getLong("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setQuantity(rs.getInt("quantity"));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public Product save(Product product) {
        boolean isUpdate = (product.getId() != null) && (product.getId() > 0);
        String query;

        if (isUpdate){
            query = "UPDATE products SET name=?, price=?, quantity=? WHERE id=?";
        } else {
            query = "INSERT INTO products (name, price, quantity) VALUES (?,?,?)";
        }

        try(Connection conn = ConnectionJdbc.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());

            if (isUpdate){
                stmt.setLong(4, product.getId());
            }

            int affectedRow = stmt.executeUpdate();

            if (!isUpdate && affectedRow > 0){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if (rs.next()){
                        product.setId(rs.getLong(1));
                    }
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = ConnectionJdbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM products WHERE id = ?")
        ){
            stmt.setLong(1, id);

            stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
