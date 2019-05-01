/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author sergio_buzzoni
 */
public class GestionObras {

    private FachadaGui fgui;
    private FachadaBaseDatos fbd;

    public GestionObras(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void visualizarObras() {
        fgui.visualizarGestionObras();
    }

    public java.util.List<Obra> obtenerObras(Integer codigo, String titulo, Integer ano, String autor, String sala, String tipo) {
        return fbd.consultarCatalogo(codigo, titulo, ano, autor, sala, tipo);
    }
    
    public void insertarObras(Obra o){
        fbd.insertarObra(o);
    }
    
    public void insertarAutorcObra(Autor a, Obra o){
        fbd.insertarAutorcObra(a, o);
    }    
    
    public void insertarAdquisicion(Integer obra, Suministrador sumin, TipoAdquisicion tipo, String fecha, Float precio){
        fbd.insertarAdquisicion(obra, sumin, tipo, fecha, precio);
    }    
}
