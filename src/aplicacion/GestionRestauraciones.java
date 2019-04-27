/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
/**
 *
 * @author basesdatos
 */
public class GestionRestauraciones {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionRestauraciones(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  
         public java.util.List<Obra> obtenerObras(String Restaurador) {
             return fbd.obtenerObras(Restaurador);
         }
    
}
