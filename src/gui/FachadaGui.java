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
    VRestaurador vrest;
    VComprarObra vcomprar;

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(fa);
        //this.vu = new VUsuario(fa);//instanciar a ventana
        this.vadmin = new VAdmin(fa);
        this.vrest = new VRestaurador(fa);
        this.vcomprar = new VComprarObra(fa);

    }

    public void iniciaVista() {
        VAutentificacion va;

        va = new VAutentificacion(vp, true, fa);
        //vp.setVisible(true);
        va.setVisible(true);
        //vu.setVisible(false);

        //vadmin.setVisible(false);
        //vrest.setVisible(false);
        //vadquirir.setVisible(true);
    }

    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va = new VAviso(vp, true, txtExcepcion);
        va.setVisible(true);
    }

    public void verAdminUsuarios() {
        vadmin.setVisible(true);
        System.out.println("ver admin");

    }

    public void verRestauracion() {
        vrest.setVisible(true);
    }

    public void verComprar() {
        vcomprar.setVisible(true);
    }

    /*
    public void verUsuarios() {
        vu.setVisible(true);
    }*/
    public void verAdquirir() {
        VAdquirir vad;

        vad = new VAdquirir(fa);
        vad.setVisible(true);
    }

    public void verAutores() {
        VAutor vau;

        vau = new VAutor(fa);
        vau.setVisible(true);
    }

    public void verSumin() {
        VSumins vs;

        vs = new VSumins(fa);
        vs.setVisible(true);
    }

    public String esRestaurador(String idRestaurador) {
        return idRestaurador;
    }

    public void setVrest(VRestaurador vrest) {
        this.vrest = vrest;
    }

    public void visualizarGestionObras() {
        VObras vo;
        vo = new VObras(vadmin, true, fa);
        vo.setVisible(true);
    }

}
