package org.montano.java.swing.jdbc.repository;

import org.montano.java.swing.jdbc.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product fintById(Long id);
    Product save(Product product);
    void delete(Long id);
}
