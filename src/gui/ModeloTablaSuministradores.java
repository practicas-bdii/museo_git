/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import aplicacion.Suministrador;
import javax.swing.table.*;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaSuministradores extends AbstractTableModel{
    private java.util.List<Suministrador> sumins;
    
    public ModeloTablaSuministradores(){
        this.sumins=new java.util.ArrayList<Suministrador>();
    }    
    
    @Override
    public int getColumnCount(){
        return 4;
    }
    
    @Override
    public int getRowCount(){
        return sumins.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";
        
        switch(col){
            case 0: nombre= "cif"; break;
            case 1: nombre= "pais"; break;
            case 2: nombre= "nome"; break;
            case 3: nombre= "tipo"; break;
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
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= sumins.get(row).getCIF(); break;
            case 1: resultado= sumins.get(row).getPais(); break;
            case 2: resultado= sumins.get(row).getNombre(); break;
            case 3: resultado= sumins.get(row).getTipo(); break;
        }
        return resultado;
    }
    
    public void setFilas(java.util.List<Suministrador> sumins){
        this.sumins = sumins;
        fireTableDataChanged();
    }
    
    public void actualizarSuministrador(int i, Suministrador s){
        this.sumins.set(i, s);
        fireTableRowsUpdated(i,i);
    }
    
    public Suministrador obtenerSuministrador(int i){
        return this.sumins.get(i);
    }
    
    public void novoSuministrador(Suministrador s){
        this.sumins.add(s);
        fireTableRowsInserted(this.sumins.size()-1, this.sumins.size()-1);
    }
    
}
