/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author alumnogreibd
 */
public class GestionAutores {
    
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    
    public GestionAutores(FachadaGui fgui,FachadaBaseDatos fbd){
        this.fgui=fgui;
        this.fbd=fbd;
    }
    
    public java.util.List<Autor> obtenerAutores(){
        return fbd.consultarAutores();
    }
    
     public void verAutores(){
        fgui.verAutores();
    }
     
    public void actualizarAutor(String nome, Autor a){
        fbd.actualizarAutor(nome, a);
    }

    public void insertarAutor(Autor a){
        fbd.insertarAutor(a);
    }
    
    public void borrarAutor(String nome){
        fbd.borrarAutor(nome);
    }
}
