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
public class GestionUsuarios {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
     //fbd.crearEdad();
     //fbd.añadirDatosEdad();
    }  
    
    
//  public Boolean comprobarAutentificacion(String idUsuario, String clave){
//      Usuario u;
//
//      u=fbd.validarUsuario(idUsuario, clave);
//      if (u!=null){
//          return u.getTipoUsuario()==TipoUsuario.Administrador;
//      } else return false;
//  }
public int comprobarAutentificacion(String idUsuario, String clave){
      Usuario u;

      u=fbd.validarUsuario(idUsuario, clave);
      if (u!=null){
            if (u.getEsAdmin()==true) return 1;
            else return 2;
        
      } else return 0;
  }
  
  
 public java.util.List<Usuario> obtenerUsuarios(String id, String nombre){
        return fbd.consultarUsuarios(id, nombre);
    }
 
 public void insertarUsuario(Usuario u){
    //comprobar si existe usuario e despois se non existe insertalo, se existe actualizase
     if(fbd.existeUsuario(u)==false){
         System.out.println("No Existe usuario se procede a insertar");
         fbd.insertarUsuario(u);}
     else{ fbd.actualizarUsuario(u);//si existeUsuario devuelve true entonces ha de actualizarse
            System.out.println("Exist usuario, se actualiza");}
 }
      
 public void borrarUsuario(String idUsuario){
    fbd.borrarUsuario(idUsuario);
}
  
// public Usuario damePrimero(String idUsuario, String nombre){
//     Usuario u;
////     u=fbd.damePrimero(idUsuario, nombre);
//     return u;
// }
}
