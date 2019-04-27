/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//import aplicacion.Categoria;
//import aplicacion.Libro;

/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    VUsuario vu;//obxeto da ventana de usuarios
    VAdmin vadmin;
    VRestaurador vrest;
    VComprarObra vcomprar;
    
   public FachadaGui(aplicacion.FachadaAplicacion fa){
     this.fa=fa;
     this.vp = new VPrincipal(fa);
     this.vu = new VUsuario(fa);//instanciar a ventana
     this.vadmin=new VAdmin(fa);
     this.vrest = new VRestaurador(fa);
     this.vcomprar= new VComprarObra(fa);
     
   } 
    
    
    
    public void iniciaVista(){
      VAutentificacion va;

        va = new VAutentificacion(vp, true, fa);
        //vp.setVisible(true);
        va.setVisible(true);
        //vu.setVisible(false);
        //vadmin.setVisible(true);
        //vrest.setVisible(false);
        //vcomprar.setVisible(false);
    }
    
   
    
    public void muestraExcepcion(String txtExcepcion){
       VAviso va;
       
       va = new VAviso(vp, true, txtExcepcion);
       va.setVisible(true);
    }

    public void verAdminUsuarios(){
       vadmin.setVisible(true);
        System.out.println("ver admin");
    
    }
    
    public void verRestauracion(){
       vrest.setVisible(true);
    }
    
    public void verComprar(){
        vcomprar.setVisible(true);
    }
    
    public void verUsuarios(){
        vu.setVisible(true);
    }
    public String esRestaurador(String idRestaurador){
        return idRestaurador;
    }

    public void setVrest(VRestaurador vrest) {
        this.vrest = vrest;
    }
   
}
