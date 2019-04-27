/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;
import aplicacion.Obra;
import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import static aplicacion.TipoUsuario.Restaurador;
import java.sql.*;
/**
 *
 * @author basesdatos
 */
public class DAORestauracion extends AbstractDAO {

   public DAORestauracion (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

   public void realizarRestauracion(int codObra, int codTraballador){
      Connection con;
      PreparedStatement stmRestauracion=null;


        con=super.getConexion();
        
        try {
        stmRestauracion=con.prepareStatement("insert into restauracion(antiguidade, traballador, fecha_ini, fecha_fin) "+
                                      " values (?,?,?,?)");
       // stmUsuario.setString(1, usuario.getIdUsuario());
        stmRestauracion.setInt(1, codObra);
        stmRestauracion.setInt(2, codTraballador);
        stmRestauracion.setDate(3, null);
        stmRestauracion.setDate(4, null);
       
        stmRestauracion.executeUpdate();
  
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmRestauracion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
   }
   public void eliminarRestauracion(int codObra){
     Connection con;
        PreparedStatement stmRestauracion=null;

        con=super.getConexion();

        try {
        stmRestauracion=con.prepareStatement("delete from restauracion where antiguidade = ?");
        stmRestauracion.setInt(1, codObra);
        stmRestauracion.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmRestauracion.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
   }
    public java.util.List<Obra> obtenerObras(String Restaurador) {
        java.util.List<Obra> resultado = new java.util.ArrayList<Obra>();
        Connection con;
        //Obtener Nombre de la obra, Estado, Fecha de Inicio, Fecha de Fin
        PreparedStatement stmListaUsuarios=null;
        ResultSet rsListaUsuarios;
        
        con=this.getConexion();
        
        String consulta = "select id_usuario, clave, nome, direccion, telefono, e_administrador" +
                                         " from traballadores ";
                                        // "where id_usuario = ?";//+
                                         //" and nombre like %?%";
       
        //else if(nombre!=null) consulta = consulta + " and nombre = ?";
     
//        try {
//         stmListaUsuarios=con.prepareStatement(consulta);
//         if (id_usuario != null){
//            stmListaUsuarios.setString(1, id_usuario);//no necesario si se ejecuta el if(nombre!=null)
//            if(nombre!=null) stmListaUsuarios.setString(2, nombre);
//        }
//        else{
//            stmListaUsuarios.setString(1, nombre);
//        }
//         //stmListaUsuarios.setString(1, id_usuario);//no necesario si se ejecuta el if(nombre!=null)
//         //stmListaUsuarios.setString(2, nombre);
//         rsListaUsuarios=stmListaUsuarios.executeQuery();
//         while (rsListaUsuarios.next()){
//             //(String idUsuario, String clave, String nombre, String direccion, String telefono, boolean esAdmin)
//             Usuario usuarioActual = new Usuario(rsListaUsuarios.getString("id_usuario"), rsListaUsuarios.getString("clave"),
//                     rsListaUsuarios.getString("nome"), rsListaUsuarios.getString("direccion"),
//                     rsListaUsuarios.getString("telefono"), rsListaUsuarios.getBoolean("e_administrador"));
//             resultado.add(usuarioActual);
//         }
//        } catch (SQLException e){
//          System.out.println(e.getMessage());
//          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
//        }finally{
//          try {stmListaUsuarios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
//        }
//      
        return resultado;
    }


    
}
