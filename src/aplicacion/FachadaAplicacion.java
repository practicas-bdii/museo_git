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
    GestionRestauraciones gr;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        cu = new GestionUsuarios(fgui, fbd);
        cs = new GestionSuministradores(fgui,fbd);
        ca = new GestionAutores(fgui,fbd);
        gr = new GestionRestauraciones(fgui, fbd);
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


    public void adminCategorias() {
        //aqui debería abrir a ventana de administración de usuarios
        // fgui.verAdminCategorias();
    }

    public gui.FachadaGui getFachada() {
        return this.fgui;
    }
    
    
    //Gestion SUMINISTRADORES
    
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
    
    public void verAdminSumin(){
        cs.verAdminSumin();
    }

    public java.util.List<Autor> obtenerAutores(){
        return ca.obtenerAutores();
    }
    //Para Restauraciones
     public java.util.List<AntiguidadeSimplif> obtenerObras(String Restaurador) {
        return gr.obtenerObras(Restaurador);
    }

     public java.util.List<AntiguidadeSimplif> obtenerDemasObras(String titulo) {
         return gr.obtenerDemasObras(titulo);
    }
      public java.util.List<AntiguidadeSimplif> obtenerTodasObras() {
         return gr.obtenerTodasObras();
    }
    public void insertaRestauracion(Integer CodObra, String Restaurador){
        gr.insertaRestauracion(CodObra, Restaurador);
    }
    
    public void finalizaRestauracion(Integer CodObra, String Restaurador, TipoEstado Estado){
        gr.finalizaRestauracion(CodObra, Restaurador, Estado);
    }
    
    public void actualizaEstado(Integer CodObra, TipoEstado Estado){
        gr.actualizaEstado(CodObra, Estado);
    }
}
