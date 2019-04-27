/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author basesdatos
 */
public class FachadaAplicacion {

    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionUsuarios cu;
    GestionSuministradores cs;
    GestionAutores ca;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        cu = new GestionUsuarios(fgui, fbd);
        cs = new GestionSuministradores(fgui,fbd);
        ca = new GestionAutores(fgui,fbd);
    }

    public static void main(String args[]) {
        FachadaAplicacion fa;

        fa = new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    public void iniciaInterfazUsuario() {
        fgui.iniciaVista();
    }

    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

    //Chama a ao metodo da clase GestionUsuarios
    public java.util.List<Usuario> obtenerUsuarios(String id, String nombre) {
        return cu.obtenerUsuarios(id, nombre);
    }

    ;
    //gestion de usuarios
    public int comprobarAutentificacion(String idUsuario, String clave) {
        return cu.comprobarAutentificacion(idUsuario, clave);
    }

    public void insertarUsuario(Usuario u) {
        cu.insertarUsuario(u);
    }

    public void adminUsuarios() {
        //aqui debería abrir a ventana de administración de usuarios
        fgui.verAdminUsuarios();
    }

    public void borrarUsuario(String idUsuario) {
        cu.borrarUsuario(idUsuario);
    }
//public Usuario damePrimero(String idUsuario, String nombre){
//   Usuario u;
//    u=cu.damePrimero(idUsuario, nombre);
//    return u;
//}
//administracion de categorias

    public void adminCategorias() {
        //aqui debería abrir a ventana de administración de usuarios
        // fgui.verAdminCategorias();
    }

    public gui.FachadaGui getFachada() {
        return this.fgui;
    }
    
    
    //Gestion SUMINISTRADORES
    public void verAdquirir(){
        cs.adminAdquirir();
    }
    
    public java.util.List<Suministrador> obtenerSumins(String cif){
      return cs.obtenerSumins(cif);
    };
   
    public void actualizarSuministrador(String cif, Suministrador s){
        cs.actualizarSuministrador(cif, s);
    }

    public void insertarSuministrador(Suministrador s){
        cs.insertarSuministrador(s);
    }
    
    public void borrarSuministrador(String cif){
        cs.borrarSuministrador(cif);
    }
    
    public void verSumin(){
        cs.verSumin();
    }

    //Gestion AUTORES
     public void verAutores(){
        cs.adminAdquirir();
    }
    
    public java.util.List<Autor> obtenerAutores(){
        return ca.obtenerAutores();
    }  
    
    public void actualizarAutor(String nome, Autor a){
        ca.actualizarAutor(nome, a);
    }

    public void insertarAutor(Autor a){
        ca.insertarAutor(a);
    }
    
    public void borrarAutor(String nome){
        ca.borrarAutor(nome);
    }
    
}
