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
    GestionObras co;
    GestionUsuarios cu;
    GestionSuministradores cs;
    GestionAutores ca;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        co = new GestionObras(fgui, fbd);
        cu = new GestionUsuarios(fgui, fbd);
        cs = new GestionSuministradores(fgui, fbd);
        ca = new GestionAutores(fgui, fbd);
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
    public java.util.List<Suministrador> obtenerSumins(String cif) {
        return cs.obtenerSumins(cif);
    }

    public void actualizarSuministrador(String cif, Suministrador s) {
        cs.actualizarSuministrador(cif, s);
    }

    public void insertarSuministrador(Suministrador s) {
        cs.insertarSuministrador(s);
    }

    public void borrarSuministrador(String cif) {
        cs.borrarSuministrador(cif);
    }

    public void verAdminSumin() {
        cs.verAdminSumin();
    }

    public java.util.List<Autor> obtenerAutores() {
        return ca.obtenerAutores();
    }

    public void visualizarObras() {
        co.visualizarObras();
    }

    public java.util.List<Obra> obtenerObras(Integer codigo, String titulo, Integer ano, String autor, String sala, String tipo) {
        return co.obtenerObras(codigo, titulo, ano, autor, sala, tipo);
    }
}
