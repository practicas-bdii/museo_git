/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import aplicacion.Autor;
import javax.swing.table.*;


/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaAutores extends AbstractTableModel {
    private java.util.List<Autor> autor;
    
     public ModeloTablaAutores(){
        this.autor=new java.util.ArrayList<Autor>();
    }
     
    @Override
    public int getColumnCount(){
        return 3;
    }
    
    @Override
    public int getRowCount(){
        return autor.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";
        
        switch(col){
            case 0: nombre= "nombre"; break;
            case 1: nombre= "fechaNacemento"; break;
            case 2: nombre= "fechaFalecemento"; break;
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
        }
        return clase;
    }
    
    @Override
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= autor.get(row).getNombre(); break;
            case 1: resultado= autor.get(row).getFechaNacemento(); break;
            case 2: resultado= autor.get(row).getFechaFalecemento(); break;
        }
        return resultado;
    }
    
    public void setFilas(java.util.List<Autor> autor){
        this.autor = autor;
        fireTableDataChanged();
    }
    
    public void actualizarAutor(int i, Autor a){
        this.autor.set(i, a);
        fireTableRowsUpdated(i,i);
    }
    
    public Autor obtenerAutor(int i){
        return this.autor.get(i);
    }
    
    public void novoAutor(Autor a){
        this.autor.add(a);
        fireTableRowsInserted(this.autor.size()-1, this.autor.size()-1);
    }
    
}
