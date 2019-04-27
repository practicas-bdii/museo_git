/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Suministrador;

/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    VAdmin vadmin;
    //VUsuario vu;//obxeto da ventana de usuarios
    //VAutores 
    //VRestaurador vrest;
    //VAdquirir vadquirir;
    
   public FachadaGui(aplicacion.FachadaAplicacion fa){
     this.fa=fa;
     this.vadmin=new VAdmin(fa);
     // this.vu = new VUsuario(fa);//instanciar a ventana
     //this.vrest = new VRestaurador(fa);
     //this.vadquirir= new VAdquirir(fa);
     
   } 
    
    
    
    public void iniciaVista(){
      VAutentificacion va;

        va = new VAutentificacion(vp, true, fa);
        //vp.setVisible(true);
        va.setVisible(true);
        //vu.setVisible(false);
        vadmin.setVisible(true);
        //vrest.setVisible(false);
        //vadquirir.setVisible(true);
    }
    
   
    
    public void muestraExcepcion(String txtExcepcion){
       VAviso va;
       
       va = new VAviso(vp, true, txtExcepcion);
       va.setVisible(true);
    }

    public void verAdminUsuarios(){
    //   vadmin.setVisible(true);
        System.out.println("ver admin");
    
    }
    
    public void verRestauracion(){
    //   vrest.setVisible(true);
    }
        
    public void verUsuarios(){
    //    vu.setVisible(true);
    }
    
    public void verAdquirir(){
        VAdquirir vad;
        
        vad = new VAdquirir(fa);
        vad.setVisible(true);
    }
    
    public void verAutores(){
        VAutor vau;
        
        vau = new VAutor(fa);
        vau.setVisible(true);
    }
    
    public void verSumin(){
        VSumins vs;
        
        vs = new VSumins(fa);
        vs.setVisible(true);
    }
   
}
