package paneles;

import datos.Usuario;
import datos.ctrlUsuarios;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import javaswingdev.chart.ModelPieChart;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import ventanas.ActualizarUsuario;
import ventanas.AgregarUsuario;

/**
 *
 * @author mesoi
 */
public class Ventana1 extends javax.swing.JPanel {

    public static DefaultTableModel modelo;

    /**
     * Creates new form Ventana1
     */
    public Ventana1() {
        initComponents();
        modelo = (DefaultTableModel) tabla1.getModel();
        // deshabilitar la selección multiple
        tabla1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //mostrargrafica();

    }

    private void cargarCSV() {
        String ruta = "";
        JFileChooser archivos = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("CSV", "csv");
        archivos.setFileFilter(filtrado);

        int respuesta = archivos.showOpenDialog(this);
        if (respuesta == archivos.APPROVE_OPTION) {
            ruta = archivos.getSelectedFile().getPath();
            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                String line; // Variable para almacenar cada línea leída del archivo
                int i = 0;
                int id = 1;
                while ((line = br.readLine()) != null) {// Lee cada línea del archivo hasta que llegue al final
                    if (i == 0) { // Si es la primera línea (encabezado), sáltala
                        i++;
                        continue;
                    }

                    String[] values = line.split(",");// Divide la línea en partes utilizando la coma como separador
                    // Llama a un método (ctrlUsuarios.agregarUsuario) para agregar un usuario con los valores extraídos de la línea
                    ctrlUsuarios.agregarUsuario(values[0].trim(), Integer.parseInt(values[1]), values[2].trim(), values[3].trim());  // Salto de línea después de cada fila
                    id++;
                    i++;
                }
            } catch (IOException e) {// Manejo de excepciones en caso de problemas de lectura del archivo
                e.printStackTrace();// Imprime información sobre la excepción
            }
        }
        //ctrlUsuarios.imprimirUsuarios();
        cargarTabla();
        cargarGrafica();
    }

    public static void cargarTabla() {
        modelo.setRowCount(0);
        Usuario temp[] = ctrlUsuarios.getAllUsers();

        for (Usuario usuario : temp) {
            if (usuario == null) {
                continue;
            }
            Object datos[] = new Object[5];
            datos[0] = usuario.getId();
            datos[1] = usuario.getNombre();
            datos[2] = usuario.getEdad();
            datos[3] = usuario.getCiudad();
            datos[4] = usuario.getOcupacion();
            modelo.addRow(datos);
        }
    }

    private String[] guardarSeleccion() {
        if (ctrlUsuarios.getSizeArray() == 0) {
            return null;
        }

        int selectRow = tabla1.getSelectedRow();
        if (selectRow == -1) {
            return null;
        }
        String[] rowData = new String[5];
        for (int col = 0; col < tabla1.getColumnCount(); col++) {
            if (col == 4) {
                int opcion = -1;
                String text = tabla1.getValueAt(selectRow, col).toString();
                System.out.println(text);
                if (text.equals("Estudiante")) {
                    opcion = 0;
                } else if (text.equals("Empleado/a")) {
                    opcion = 1;
                } else {
                    opcion = 2;
                }
                rowData[col] = opcion + "";
                continue;
            }
            rowData[col] = tabla1.getValueAt(selectRow, col).toString();

        }
        System.out.println(Arrays.toString(rowData));
        return rowData;
    }

    public static void cargarGrafica() {
        Usuario[] datos = ctrlUsuarios.getOcupaciones();
        if (ctrlUsuarios.getSizeArray() == 0) {
            return;
        }
        pieChart1.clearData();
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] == null) {
                continue;
            }
            if (i == 0) {
                pieChart1.addData(new ModelPieChart("Estudiante", Integer.parseInt(datos[i].getOcupacion()), Color.BLUE));
            } else if (i == 1) {
                pieChart1.addData(new ModelPieChart("Empleado/a", Integer.parseInt(datos[i].getOcupacion()), Color.CYAN));
            } else {
                pieChart1.addData(new ModelPieChart("Desempleado/a", Integer.parseInt(datos[i].getOcupacion()), Color.GREEN));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        pieChart1 = new javaswingdev.chart.PieChart();

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Carga Masiva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Crear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nombre", "edad", "ciudad", "Ocupacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla1MousePressed(evt);
            }
        });
        tabla1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabla1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(0).setResizable(false);
            tabla1.getColumnModel().getColumn(1).setResizable(false);
            tabla1.getColumnModel().getColumn(2).setResizable(false);
            tabla1.getColumnModel().getColumn(3).setResizable(false);
            tabla1.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton5.setText("PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Form Title");
        MessageFormat footer = new MessageFormat("test");
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.PORTRAIT);
            tabla1.print(JTable.PrintMode.FIT_WIDTH, header, footer, true, set, true);
            System.out.println("Archivo generado");
        } catch (java.awt.print.PrinterException e) {
            System.out.println("Error" + e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cargarCSV();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        AgregarUsuario agregarU = new AgregarUsuario(this);
        agregarU.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabla1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabla1PropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_tabla1PropertyChange

    private void tabla1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MousePressed
        // TODO add your handling code here:
        //guardarSeleccion();
    }//GEN-LAST:event_tabla1MousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String[] datos = guardarSeleccion();
        if (datos == null) {
            JOptionPane.showMessageDialog(this, "No se seleccionaron Datos");
            return;
        }
        ActualizarUsuario actualizar = new ActualizarUsuario(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]), datos[3], Integer.parseInt(datos[4]));
        actualizar.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String[] datos = guardarSeleccion();
        if (datos == null) {
            JOptionPane.showMessageDialog(this, "No se seleccionaron Datos");
            return;
        }
        System.out.println(datos[0]);
        if (ctrlUsuarios.eliminarUsuario(Integer.parseInt(datos[0]))) {
            JOptionPane.showMessageDialog(this, "Se elimino el Usuario");
        } else {
            JOptionPane.showMessageDialog(this, "Error al momento de borrar al usuario");
        }
        cargarTabla();
        cargarGrafica();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javaswingdev.chart.PieChart pieChart1;
    public static javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
