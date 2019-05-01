/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Antiguidade;
import aplicacion.AntiguidadeSimplif;
import aplicacion.Autor;
import aplicacion.Obra;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import aplicacion.Suministrador;
import aplicacion.TipoAdquisicion;
import aplicacion.TipoEstado;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOObras daoObras;
    private DAOUsuarios daoUsuarios;
    private DAOSuministradores daoSuministradores;
    private DAOAutores daoAutores;
    private DAORestauracion daorestauracion;

    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {

        Properties configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            daoUsuarios = new DAOUsuarios(conexion, fa);
            daorestauracion = new DAORestauracion(conexion, fa);
            daoAutores = new DAOAutores(conexion, fa);
            daoSuministradores = new DAOSuministradores(conexion, fa);

        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }

    }

    public Usuario validarUsuario(String idUsuario, String clave) {
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }

    //consultar usuarios, chamar ao DAO
    public java.util.List<Usuario> consultarUsuarios(String id, String nombre) {
        return daoUsuarios.consultarUsuarios(id, nombre);
    }

    public void insertarUsuario(Usuario u) {
        daoUsuarios.insertarUsuario(u);
    }

    public boolean existeUsuario(Usuario u) {
        if (daoUsuarios.existeUsuario(u) == true) {
            System.out.print("Existe usuario");
        } else {
            System.out.println("No Existe usuario");
        }
        return daoUsuarios.existeUsuario(u);

    }

    public void actualizarUsuario(Usuario u) {
        daoUsuarios.actualizaUsuario(u);
    }

//    public Usuario damePrimero(String idUsuario, String nombre){
//        Usuario u;
//        u=daoUsuarios.damePrimero(idUsuario, nombre);
//        return u;
//    }
    public void borrarUsuario(String idUsuario) {
        daoUsuarios.borrarUsuario(idUsuario);
    }

    //Gestion SUMINISTRADORES
    public java.util.List<Suministrador> consultarSumins(String cif) {
        return daoSuministradores.consultarSumins(cif);
    }

    public void actualizarSuministrador(String cif, Suministrador s) {
        daoSuministradores.actualizarSuministrador(cif, s);
    }

    public void insertarSuministrador(Suministrador s) {
        daoSuministradores.insertarSuministrador(s);
    }

    public void borrarSuministrador(String cif) {
        daoSuministradores.borrarSuministrador(cif);
    }

    //Gestion AUTORES
    public java.util.List<Autor> consultarAutores(String nome) {
        return daoAutores.consultarAutores(nome);
    }
    
    public java.util.List<Autor> consultarAutoresLista() {
        return daoAutores.consultarAutoresLista();
    }

    public java.util.List<Obra> consultarCatalogo(Integer codigo, String titulo, Integer ano, String autor, String sala, String tipo) {
        return daoObras.consultarCatalogo(codigo, titulo, ano, autor, sala, tipo);
    }

    public void actualizarAutor(String nome, Autor a) {
        daoAutores.actualizarAutor(nome, a);
    }

    public void insertarAutor(Autor a) {
        daoAutores.insertarAutor(a);
    }

    public void borrarAutor(String nome) {
        daoAutores.borrarAutor(nome);
        //Gestion de Restauracion
    }

    //Gestion OBRAS
    
    public java.util.List<AntiguidadeSimplif> obtenerObras(String Restaurador) {
        System.out.println("fbd");
        return daorestauracion.obtenerObras(Restaurador);
    }

    public java.util.List<AntiguidadeSimplif> obtenerDemasObras(String titulo) {
        //System.out.println("fbd");
        return daorestauracion.obtenerDemasObras(titulo);
    }

    public void insertaRestauracion(Integer CodObra, String Restaurador){
       if(daorestauracion.existeRestauracion(CodObra)==false)
        daorestauracion.realizarRestauracion(CodObra, Restaurador);
        daorestauracion.setEstadoAntigu(TipoEstado.restaurandose, CodObra);
    }

    public java.util.List<AntiguidadeSimplif> obtenerTodasObras() {
        return daorestauracion.obtenerTodasObras();
    }
  
    public void finalizaRestauracion(Integer CodObra, String Restaurador, TipoEstado Estado){
        daorestauracion.finalizaRestauracion(CodObra, Restaurador);
        daorestauracion.setEstadoAntigu(Estado, CodObra);
    }
   
    public void insertarObra(Obra o){
        daoObras.insertarObra(o);
    }
    
    public void insertarAutorcObra(Autor a, Obra o){
        daoObras.insertarAutcObra(a, o);
    }
    
    public void insertarAdquisicion(Integer obra, Suministrador sumin, TipoAdquisicion tipo, String fecha, Float precio){
        daoObras.insertarAdquisicion(obra, sumin, tipo, fecha, precio);
    }
}
