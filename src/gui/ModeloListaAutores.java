/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Autor;

/**
 *
 * @author basesdatos
 */
public class ModeloListaAutores extends javax.swing.AbstractListModel {
    java.util.List<Autor> autor;

    public ModeloListaAutores(){
        this.autor = new java.util.ArrayList<Autor>();
     
    }

    @Override
    public int getSize(){
        return this.autor.size();
    }

    @Override
    public String getElementAt(int i){
        return autor.get(i).getNombre();
    }

    public void nuevoAutor(Autor c){
        this.autor.add(c);
        fireIntervalAdded(this, this.autor.size()-1, this.autor.size()-1);
    }

    public void borrarElemento(int i){
        Autor e;
        e = this.autor.get(i);
        this.autor.remove(i);
        fireIntervalRemoved(this,i,i);
    }
    
    public Autor obtenerAutor(int i){
        return this.autor.get(i);
    }

    public void setAutores(java.util.List<Autor> autor){
       this.autor = autor;
       fireContentsChanged(this, 0, autor.size()-1);
    }
    
    public java.util.List<Autor> getAutores(){
        return this.autor;
    }
}
