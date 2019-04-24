/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Obra;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaObras extends AbstractTableModel {

    private java.util.List<Obra> obras;

    public ModeloTablaObras() {
        this.obras = new java.util.ArrayList<Obra>();
    }

    public int getColumnCount() {
        return 6;
    }

    public int getRowCount() {
        return obras.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Codigo";
                break;
            case 1:
                nombre = "Título";
                break;
            case 2:
                nombre = "Autor";
                break;
            case 3:
                nombre = "Ano";
                break;
            case 4:
                nombre = "Tipo";
                break;
            case 5:
                nombre = "Sala";
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.Integer.class;
                break;
            case 1:
                clase = java.lang.String.class;
                break;
            case 2:
                clase = java.lang.String.class;
                break;
            case 3:
                clase = java.lang.Integer.class;
                break;
            case 4:
                clase = java.lang.String.class;
                break;
            case 5:
                clase = java.lang.String.class;
                break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public Object getValueAt(int row, int col) {
        Object resultado = null;

        switch (col) {
            case 0:
                resultado = obras.get(row).getCodigo();
                break;
            case 1:
                resultado = obras.get(row).getTitulo();
                break;
            case 2:
              //  resultado = obras.get(row).getAutor();
                break;
            case 3:
                resultado = obras.get(row).getAno();
                break;
            case 4:
                // usar instanceof resultado = obras.get(row).getTipo();
                break;
            case 5:
                resultado = obras.get(row).getSala();
                break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Obra> obras) {
        this.obras = obras;
        fireTableDataChanged();
    }

    public Obra obtenerLibro(int i) {
        return this.obras.get(i);
    }

}
