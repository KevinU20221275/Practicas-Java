package org.montano.java.swing.jdbc;

import org.montano.java.swing.jdbc.models.*;
import org.montano.java.swing.jdbc.repository.*;
import org.montano.java.swing.jdbc.utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class JdbcSwingCRUDProject extends JFrame {
    private Container p;
    private JTextField nameField = new JTextField();
    private JTextField priceField = new JTextField();
    private JTextField quantityField = new JTextField();
    private ProductTableModel tableModel = new ProductTableModel();
    private ProductRepository productRepository;

    private Long id = 0L;
    private int row;

    public JdbcSwingCRUDProject() throws HeadlessException {
        super("Swing: GUI con Base de Datos MySQL!");
        p = getContentPane();
        p.setLayout(new BorderLayout(20,10));
        this.productRepository = new ProductRepositoryImpl();

        // los labels se pasan como un array con el texto que se mostrara
        String[] labels = new String[] {"Nombre: ", "Precio: ", "Cantidad: "};

        // los campos del formulario tambien se parran como una lista
        ArrayList<JTextField> fields = new ArrayList<>();
        fields.add(nameField);
        fields.add(priceField);
        fields.add(quantityField);

        // el metodo itera el array de labels y va agregando un label y un campo por ciclo
        // importante los labels y campos se ingresen en orden
        // una vez termina de agregar retorna el panel
        JPanel formPanel = CreateFormPanel.getFormPanel(labels, fields);

        // agrega el boton de guardar al formulario
        JButton buttonSave = new JButton("Guardar");
        formPanel.add(buttonSave);

        // agrega el evento de click
        buttonSave.addActionListener(this::saveAction);

        // creacion de la tabla donde se mostraran los registros
        JPanel tablePanel = new JPanel(new FlowLayout());
        JTable jTable = new JTable();
        jTable.setModel(this.tableModel); // aqui se pasa nuestro modelo de tabla

        // agrega un evento de click sobre la tabla para obtener la fila
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                row = jTable.rowAtPoint(e.getPoint()); // obtiene la fila donde se hizo el click
                int column = jTable.columnAtPoint(e.getPoint()); // obtiene la columna donde se hizo click

                // si la fila es un indice valido y la columna es la indice 4 "Eliminar" invoca al metodo deleteAction
                if (row > -1 && column == 4){
                    deleteAction();
                } else if (row > -1 && column > -1){ // si no se llama al editAction
                    editAction();
                }
            }
        });

        // agrega scroll a la tabla
        JScrollPane scroll = new JScrollPane(jTable);
        tablePanel.add(scroll);

        // configuraciones basicas de la tabla
        p.add(tablePanel, BorderLayout.SOUTH);
        p.add(formPanel, BorderLayout.NORTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // accion de guardar/editar en la base de datos
    private void saveAction(ActionEvent e){
        // obtiene los valores de los campos
        String name = nameField.getText();

        // por debajo IsNumber válida que los valores sean numericos
        double price = IsNumber.tryConvertToDouble(priceField);
        int quantity = IsNumber.tryConvertToInt(quantityField);

        // si paso instancia un nuevo producto si el id es 0 esta creando un nuevo registro por eso
        // asignamos null al id, si no esta editando y asignamos el id
        Product newProduct = new Product(id==0?null:id, name, price, quantity);

        // valida que el nombre no este en blanco y que los valores numericos sena mayores a cero
        ArrayList<String> errors = ValidateProduct.validateProduct(newProduct);

        // si erros no es una lista vacia algo no paso la validacion y se muestra un dialog con los errores
        if (!errors.isEmpty()){
            JOptionPane.showMessageDialog(null, errors.toArray(), "Error en la validacion", JOptionPane.ERROR_MESSAGE);
        } else {
            // pasa el producto al repositorio, se usa el mismo metodo para crear y actualizar
            Product productDB = productRepository.save(newProduct);

            // actualiza la tabla
            updateTable(productDB);

            // limpia los campos
            reset();
        }
    }

    // llena los campos cuando con los datos de la fila que se registro el clickc
    private void editAction(){
        id = (Long) tableModel.getValueAt(row, 0);
        nameField.setText(tableModel.getValueAt(row, 1).toString());
        priceField.setText(tableModel.getValueAt(row, 2).toString());
        quantityField.setText(tableModel.getValueAt(row, 3).toString());
    }

    // metodo cuando se va a eliminar, muestra una advertencia previo a eliminar
    private void deleteAction(){
        int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el registro " +
                        tableModel.getValueAt(row, 1).toString() + " ?", "Cuidado Eliminar Item",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION){
            productRepository.delete((Long) tableModel.getValueAt(row, 0));
            tableModel.getRows().remove(row);
            tableModel.fireTableDataChanged();
        }

        reset();
    }

    // actualiza la tabla para create y edit
    private void updateTable(Product product){
        if (id == 0){
            tableModel.getRows().add(new Object[]{product.getId(), product.getName(), product.getPrice(), product.getQuantity(), "Eliminar"});
            tableModel.fireTableDataChanged();
        } else if (id > 0) {
            tableModel.setValueAt(id, row, 0);
            tableModel.setValueAt(product.getName(), row, 1);
            tableModel.setValueAt(product.getPrice(), row, 2);
            tableModel.setValueAt(product.getQuantity(), row, 3);
        }
    }

    // metodo para limpiar los campos
    private void reset() {
        id = 0L;
        row = -1;
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }

    // metodo main para probar la ventana
    public static void main(String[] args) {
        new JdbcSwingCRUDProject();
    }
}
