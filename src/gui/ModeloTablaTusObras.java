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
public class ModeloTablaTusObras extends AbstractTableModel{
    private java.util.List<Obra> obras;

    public ModeloTablaTusObras(){
        this.obras=new java.util.ArrayList<Obra>();
    }

    public int getColumnCount (){
        return 4;
    }

    public int getRowCount(){
        return obras.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre= "Estado"; break;
            case 2: nombre= "Fecha Inicio"; break;
            case 3: nombre= "Fecha Fin"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase= java.lang.String.class; break;
            case 3: clase= java.lang.String.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= obras.get(row).getTitulo(); break;
            //case 1: resultado= obras.get(row).getNombre(); break;//estado
            //case 2: resultado=obras.get(row).getEmail();break;//fecha inicio
            //case 3: resultado=obras.get(row).getTipoUsuario(); break;//fecha fin
        }
        return resultado;
    }

    public void setFilas(java.util.List<Obra> obras){
        this.obras=obras;
        fireTableDataChanged();
    }

    public Obra obtenerUsuario(int i){
        return this.obras.get(i);
    }

}
