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
public class GestionSuministradores {
        
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    
    public GestionSuministradores(FachadaGui fgui,FachadaBaseDatos fbd){
        this.fgui=fgui;
        this.fbd=fbd;
    }
    
    public java.util.List<Suministrador> obtenerSumins(String cif){
        return fbd.consultarSumins(cif);
    }
    
    public void actualizarSuministrador(String cif, Suministrador s){
        fbd.actualizarSuministrador(cif, s);
    }
    
    public void insertarSuministrador(Suministrador s){
        fbd.insertarSuministrador(s);
    }
    
    public void borrarSuministrador(String cif){
        fbd.borrarSuministrador(cif);
    }
    
    public void verSumin(){
        fgui.verSumin();
    }
    
    public void adminAdquirir(){
        fgui.verAdquirir();
    }
    
}
