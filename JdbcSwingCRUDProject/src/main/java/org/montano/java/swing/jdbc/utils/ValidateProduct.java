package org.montano.java.swing.jdbc.utils;

import org.montano.java.swing.jdbc.models.Product;

import java.util.ArrayList;

public class ValidateProduct {
    public static ArrayList<String> validateProduct(Product product){
        ArrayList<String> errors = new ArrayList<>();

        if (product.getName().isBlank()){
            errors.add("Debe ingresar el nombre!");
        }

        if (product.getPrice() <= 0){
            errors.add("El precio es requerido y numerico mayor a 0");
        }

        if (product.getQuantity() <= 0){
            errors.add("La cantidad debe ser mayor a cero");
        }


        return errors;
    }
}
