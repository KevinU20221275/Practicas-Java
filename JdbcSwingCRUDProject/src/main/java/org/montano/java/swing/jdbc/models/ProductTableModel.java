package org.montano.java.swing.jdbc.models;

import org.montano.java.swing.jdbc.repository.ProductRepository;
import org.montano.java.swing.jdbc.repository.ProductRepositoryImpl;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {
    private String[] columns = new String[]{"id", "nombre", "precio", "cantidad", "Accion"};
    private ArrayList<Object[]> rows = new ArrayList<>();

    public ProductTableModel(){
        ProductRepository productRepository = new ProductRepositoryImpl();
        List<Product> products = productRepository.findAll();

        for (Product p: products){
            Object[] row = {p.getId(), p.getName(), p.getPrice(), p.getQuantity(), "Eliminar"};
            rows.add(row);
        }
    }

    public ArrayList<Object[]> getRows(){
        return rows;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        rows.get(rowIndex)[columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int column){
        return columns[column];
    }
}