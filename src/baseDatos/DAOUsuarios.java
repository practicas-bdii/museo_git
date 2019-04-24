/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import static aplicacion.TipoUsuario.Restaurador;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAOUsuarios extends AbstractDAO {

   public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Usuario validarUsuario(String idUsuario, String clave){
        Usuario resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;

        con=this.getConexion();

        try {
        stmUsuario=con.prepareStatement("select id_usuario, nome, clave, telefono, direccion, e_administrador "+
                                        "from traballadores "+
                                        "where id_usuario = ? and clave = ?");
        stmUsuario.setString(1, idUsuario);
        stmUsuario.setString(2, clave);
        rsUsuario=stmUsuario.executeQuery();
        if (rsUsuario.next()){    /*String idUsuario, String clave, String nombre, String direccion, String telefono, boolean esAdmin*/
                                resultado = new Usuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("clave"),
                                rsUsuario.getString("nome"), rsUsuario.getString("direccion"),
                                rsUsuario.getString("telefono"), rsUsuario.getBoolean("e_administrador"));

        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    public java.util.List<Usuario> consultarUsuarios(String id_usuario, String nombre){
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Connection con;
        PreparedStatement stmListaUsuarios=null;
        ResultSet rsListaUsuarios;
        
        con=this.getConexion();
        
        String consulta = "select id_usuario, clave, nome, direccion, telefono, e_administrador" +
                                         " from traballadores ";
                                        // "where id_usuario = ?";//+
                                         //" and nombre like %?%";
        if (id_usuario != null){
            consulta = consulta + " where id_usuario = ?";
            if(nombre!=null) consulta = consulta + " and nome = ?";
        }
        else{
            consulta = consulta + " where nome like %?%";
        }
        //else if(nombre!=null) consulta = consulta + " and nombre = ?";
     
        try {
         stmListaUsuarios=con.prepareStatement(consulta);
         if (id_usuario != null){
            stmListaUsuarios.setString(1, id_usuario);//no necesario si se ejecuta el if(nombre!=null)
            if(nombre!=null) stmListaUsuarios.setString(2, nombre);
        }
        else{
            stmListaUsuarios.setString(1, nombre);
        }
         //stmListaUsuarios.setString(1, id_usuario);//no necesario si se ejecuta el if(nombre!=null)
         //stmListaUsuarios.setString(2, nombre);
         rsListaUsuarios=stmListaUsuarios.executeQuery();
         while (rsListaUsuarios.next()){
             //(String idUsuario, String clave, String nombre, String direccion, String telefono, boolean esAdmin)
             Usuario usuarioActual = new Usuario(rsListaUsuarios.getString("id_usuario"), rsListaUsuarios.getString("clave"),
                     rsListaUsuarios.getString("nome"), rsListaUsuarios.getString("direccion"),
                     rsListaUsuarios.getString("telefono"), rsListaUsuarios.getBoolean("e_administrador"));
             resultado.add(usuarioActual);
         }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmListaUsuarios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
      
        return resultado;
    }
    
    public boolean existeUsuario(Usuario usuario){
       Connection con;
       PreparedStatement stmUsuario=null;
       con=super.getConexion();
       ResultSet rsListaUsuarios;
        try {
        stmUsuario=con.prepareStatement("select * from traballadores "+
                                      " where id_usuario=? ");
        //"and clave=? and nombre=? and direccion=? and email=? and tipo_usuario=? ");
        stmUsuario.setString(1, usuario.getIdUsuario());
        rsListaUsuarios=stmUsuario.executeQuery();
        if (rsListaUsuarios.next()){
             //(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
            return true;//significa que ya existe un usuario
        } 
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return false;//no encontró el usuario
    }
    
    public void insertarUsuario(Usuario usuario){
        Connection con;
        PreparedStatement stmUsuario=null;


        con=super.getConexion();
        System.out.println(usuario.getIdUsuario());
        
        try {
        stmUsuario=con.prepareStatement("insert into traballadores(id_usuario, nome, clave, telefono, direccion, e_administrador) "+
                                      " values (?,?,?,?,?,?)");
        stmUsuario.setString(1, usuario.getIdUsuario());
        stmUsuario.setString(2, usuario.getNombre());
        stmUsuario.setString(3, usuario.getClave());
        stmUsuario.setString(4, usuario.getTelefono());
        stmUsuario.setString(5, usuario.getDireccion());
        stmUsuario.setBoolean(6, usuario.getEsAdmin());
        stmUsuario.executeUpdate();

        
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

//    public Usuario damePrimero(String idUsuario, String nombre){
//         java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
//        Connection con;
//        PreparedStatement stmListaUsuarios=null;
//        ResultSet rsListaUsuarios;
//     //   Usuario usuarioVacio=new Usuario("","","","","",Normal,null);
//        con=this.getConexion();
//        
//        String consulta = "select id_usuario, clave, nombre, direccion, email, tipo_usuario" +
//                                         " from usuario "+
//                                         "where id_usuario = ?";//+
//                                         //" and nombre like %?%";
//                
//    
//     
//        try {
//         stmListaUsuarios=con.prepareStatement(consulta);
//         stmListaUsuarios.setString(1, idUsuario);
//         rsListaUsuarios=stmListaUsuarios.executeQuery();
//        while (rsListaUsuarios.next()){
//             //(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo)
////             Usuario usuarioActual = new Usuario(rsListaUsuarios.getString("id_usuario"), rsListaUsuarios.getString("clave"),
////                     rsListaUsuarios.getString("nombre"), rsListaUsuarios.getString("direccion"),
////                     rsListaUsuarios.getString("email"), TipoUsuario.valueOf(rsListaUsuarios.getString("tipo_usuario")));
////            return usuarioActual;
//        }
//        } catch (SQLException e){
//          System.out.println(e.getMessage());
//          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
//        }finally{
//          try {stmListaUsuarios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
//        }
//        
//        //return usuarioVacio;
//    }
    
    public void actualizaUsuario(Usuario u){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=super.getConexion();

        try {//traballadores(id_usuario, nome, clave, telefono, direccion, e_administrador)
        stmUsuario=con.prepareStatement("update traballadores "+
                                    "set clave=?, "+
                                    "    nome=?, "+
                                    "    direccion=?, "+
                                    "    telefono=?, "+
                                    "    e_administrador=? "+
                                    "where id_usuario=?");
        stmUsuario.setString(1, u.getClave());
        stmUsuario.setString(2, u.getNombre());
        stmUsuario.setString(3, u.getDireccion());
        stmUsuario.setString(4, u.getTelefono());
        stmUsuario.setBoolean(5, u.getEsAdmin());
        stmUsuario.setString(6, u.getIdUsuario());
        stmUsuario.executeUpdate();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void borrarUsuario(String idUsuario){
        Connection con;
        PreparedStatement stmUsuario=null;

        con=super.getConexion();

        try {
        stmUsuario=con.prepareStatement("delete from traballadores where id_usuario = ?");
        stmUsuario.setString(1, idUsuario);
        stmUsuario.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
}
