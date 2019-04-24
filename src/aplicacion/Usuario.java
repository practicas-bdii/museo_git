package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public class Usuario {
    private String idUsuario;
    private String clave;
    private String nombre;
    public String telefono;
    private String direccion;
    private boolean esAdmin;

   
   public Usuario (String idUsuario, String clave, String nombre, String direccion, String telefono, boolean esAdmin){
    this.idUsuario=idUsuario;
    this.clave=clave;
    this.nombre=nombre;
    this.direccion=direccion;
    this.telefono=telefono;
    this.esAdmin=esAdmin;
   }

   public String getIdUsuario(){

       return this.idUsuario;
   }

   public String getClave(){

       return this.clave;
   }

   public String getNombre(){

       return this.nombre;
   }

   public String getDireccion(){

       return this.direccion;
   }

   public String getTelefono(){

       return this.telefono;
   }
   
   public boolean getEsAdmin(){
       
       return this.esAdmin;
   }

}
