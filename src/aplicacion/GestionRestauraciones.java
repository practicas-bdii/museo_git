/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionRestauraciones {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionRestauraciones(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  
    
    public java.util.List<AntiguidadeSimplif> obtenerObras(String Restaurador) {
         System.out.println("gestion rest");
        return fbd.obtenerObras(Restaurador);
    }

    public java.util.List<AntiguidadeSimplif> obtenerDemasObras(String titulo) {
        System.out.println("gestion rest");
        return fbd.obtenerDemasObras(titulo);
    }
    public void insertaRestauracion(Integer CodObra, String Restaurador){
        fbd.insertaRestauracion(CodObra, Restaurador);
    }
     public java.util.List<AntiguidadeSimplif> obtenerTodasObras() {
         return fbd.obtenerTodasObras();
    }
     public void finalizaRestauracion(Integer CodObra, String Restaurador){
        fbd.finalizaRestauracion(CodObra, Restaurador);
    }
    
}
